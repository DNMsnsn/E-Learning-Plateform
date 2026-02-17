package com.CharRoom;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.HandshakeResponse;
import jakarta.websocket.server.HandshakeRequest;
import jakarta.websocket.server.ServerEndpointConfig;

public class HttpSessionConfigurator extends ServerEndpointConfig.Configurator {
		
	public void modifyHandshake(ServerEndpointConfig config, HandshakeRequest req, HandshakeResponse res) {
		HttpSession session = (HttpSession) req.getHttpSession();
		config.getUserProperties().put("session", session);
	}
}
