<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ChatRoom</title>
    <link rel="stylesheet" href="css/chatStyle.css">
</head>
<body>
	
	<div class="logo"></div>

	<nav class="hdr">
	    <a href="courses"><button class="b1"></button></a>
	    <a href="HomeIndex"><button class="bb"></button></a>
	    <a href="profile"><button class="bc"></button></a>
	    <a href="ChatIndex"><button class="cr"></button></a>
  	</nav>

	<%
  	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	
	if(session.getAttribute("unm") == null) {
		response.sendRedirect("login.jsp");
		return;
	}
 	%>
 	
 	<%
 		HttpSession chatSession = request.getSession();
 		
 		
 	%>

    <nav class="msg"></nav><br>
    <input type="text" class="inp" placeholder="Send a message...">
    <button class="sub" onclick="sendMessage()"></button>

    <script src="css/chatScript.js"></script>
</body>
</html>