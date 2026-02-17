package com.CharRoom;

import java.io.IOException;

import java.util.Collections;
import java.util.HashSet;
// import java.util.List;
import java.util.Set;

import com.DAO.UserDaoImpl;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.EndpointConfig;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chat", configurator = HttpSessionConfigurator.class)
public class ChatEndpoint {
	
	private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<>());
	
	private HttpSession httpSession;
	
	UserDaoImpl dao = new UserDaoImpl();

	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		this.httpSession = (HttpSession) config.getUserProperties().get("session");
		sessions.add(session);
		
		String unm = (String) httpSession.getAttribute("unm");
		String fullMsg = "**/@" + unm + " has been connected. <br>";
		String historic = String.join("", dao.messages());
		
		
		
		broadcast(historic + "<br>" + fullMsg);
	}
	
	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		String unm = (String) httpSession.getAttribute("unm");
		int id = (int) httpSession.getAttribute("id");	
		String fullMsg = "**/@" + unm + " : " + message + "<br>";
		
		
		broadcast(fullMsg);
		
		dao.saveMessage(id, "**/@" + unm, message);
	}
	
	@OnClose 
	public void onClose(Session session) {
		String unm = (String) httpSession.getAttribute("unm");
		String fullMsg = "**/@" + unm + " has been disconnected <br>";
		
		broadcast(fullMsg);
	}
	
	@OnError
	public void onError(Session session, Throwable throwable) {
		String unm = (String) httpSession.getAttribute("unm");
		
		System.err.println("Erreur avec le client " + unm + " : " + throwable.getMessage());
		broadcast("**/@" + unm + " rencontre des problemes de connexion... <br>");
	}
	
	private void broadcast(String message) {
		synchronized(sessions) {
			for(Session s : sessions) {
				if(s.isOpen()) {
					s.getAsyncRemote().sendText(message);
				}
			}
		}
	}
	
	/**
	private void broadcast(List<String> message) {
		synchronized(sessions) {
			for(Session s : sessions) {
				if(s.isOpen()) {
					s.getAsyncRemote().sendText(String.join("\n", message));
				}
			}
		}
	}
	*/
	
}
