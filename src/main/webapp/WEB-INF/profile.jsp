<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>
<%@ page import="com.DAO.Course" %>

<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Profile</title>
  <link rel="stylesheet" href="css\profStyle.css">
</head>
<body>

	<div class="logo"></div>

	<%
  	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	
	if(session.getAttribute("unm") == null) {
		response.sendRedirect("login.jsp");
		return;
	}
 	%>

  <nav class="hdr">
    <a href="courses"><button class="b1"></button></a>
    <a href="HomeIndex"><button class="bb"></button></a>
    <a href="profile"><button class="bc"></button></a>
    <a href="ChatIndex"><button class="cr"></button></a>
  </nav>
  
  <%
  	HttpSession profileSession = request.getSession();
  	String unm = (String) profileSession.getAttribute("unm");
  	String func = (String) profileSession.getAttribute("func");
  	String city = (String) profileSession.getAttribute("city");
  	String avatar = (String) profileSession.getAttribute("avatar");
  	int score = (int) profileSession.getAttribute("score");
  %>

	
  <div class="box">
    <img src="<%= avatar %>" alt="avatar" class="pic" onclick="avatar()">
    <h2 class="unm"><%= unm %></h2>
    <p class="func"><%= func %></p>
    <p class="city"><%= city %></p>
    <p class="score">XP : <%= score %></p>
    <a class="btn" onclick="pubShow()">Publish a Course</a>
  </div>
  
  <!-- List -->

  <div class="course-list">
  
  <% 
  	List<Course> course = (List<Course>) request.getAttribute("courses");
  	
  	if(course != null){
  		for(Course c : course) {
  %>
    <div class="course-card">
      <h1><%= c.getTitle() %></h1>
      <h3><%= c.getUname() %></h3>
      <p><%= c.getDescription() %></p>
      <form action="deleteCourse" method="post">
      	<input type="hidden" name="title" value="<%= c.getTitle() %>">
      	<input type="hidden" name="unm" value="<%= c.getUname() %>">
      	<input type="submit" class="dlCrs" value="">
      </form>
    </div>

    <div class="course-page hide">
      <button class="close" onclick="closePage()"></button>
      <nav class="page-content">
        <h1><%= c.getTitle() %></h1>
        <p><%= c.getDescription() %></p>
        <p><%= c.getContent() %></p>
        <h3><%= c.getUname() %></h3>
      </nav>
    </div>
    
    <%	} } %>
    </div>
  
  <div class="pub">
    <button class="close" onclick="pubClose()"></button>
    <div class="pubDiv">
      <form action="PublisherServlet" method="post">
        <label for="ttl">Title</label><br>
        <input type="text" id="ttl" name="title" maxlength="255" required><br>
        <label for="desc">Course Description</label><br>
        <textarea name="desc" id="desc" maxlength="10000" required></textarea><br>
        <label for="cnt">Content</label><br>
        <textarea name="content" id="cnt" maxlength="65500" required></textarea><br>
        <input type="submit" value="Publish" class="butpub">
    </form>
    </div>
  </div>
  
  <nav class="setpos">
    <button class="setbut" onclick="setshw()"></button>
  </nav>
  
  <form action="LogoutServlet" method="get" style="display:inline;">
      <button type="submit" class="logout" data-tooltip="Se déconnecter"></button>
  </form>

  <nav class="back">
  	<nav class="frontpic">
      <h2 class="picTit">Choose a new Avatar !</h2>
      <nav class="accord">
        <img src="css/avatars/av1.jpg" alt="Rick" class="myAvatar">
        <img src="css/avatars/av2.jpg" alt="chainsaw" class="myAvatar">
        <img src="css/avatars/av3.jpg" alt="pokemon" class="myAvatar">
        <img src="css/avatars/av4.jpg" alt="jjk" class="myAvatar">
        <img src="css/avatars/av5.jpg" alt="demon" class="myAvatar">
        <img src="css/avatars/av6.jpg" alt="java" class="myAvatar">
        <img src="css/avatars/av7.jpg" alt="chill" class="myAvatar">
      </nav>
      <form action="AvatarUpdate" method="post">
      	<input type="hidden" name="av" class="av" value="">
      	<button type="submit" class="select">Select</button>
      </form>
    </nav>
    
    <%
    String fnm = (String) request.getSession().getAttribute("fnm");
    String snm = (String) request.getSession().getAttribute("snm");
    String mail = (String) request.getSession().getAttribute("mail");
    String psw = (String) request.getSession().getAttribute("psw");
    %>
    
    <div class="front">
        <h1 class="httl">Settings</h1>
        <form action="ProfileSetServlet" method="post" class="form">
            <label for="fnm">First Name</label><br>
            <input type="text" id="fnm" name="fnm" class="inp" value="<%= fnm %>" placeholder="Entrez votre nom" required><br>

            <label for="snm">Second Name</label><br>
            <input type="text" id="snm" name="snm" class="inp" value="<%= snm %>" placeholder="Entrez votre prenom" required><br>

            <label for="unm">Username</label><br>
            <input type="text" id="unm" name="unm" class="inp" value="<%= unm %>" placeholder="Entrez votre username" required><br>

            <label for="fnc">Function</label><br>
            <input type="text" id="fnc" name="fnc" class="inp" value="<%= func %>" placeholder="Entrez votre travaille" required><br>

            <label for="city">City</label><br>
            <input type="text" id="city" name="city" class="inp" value="<%= city %>" placeholder="Entrez votre ville" required><br>

            <label for="ml">Email</label><br>
            <input type="email" id="ml" name="ml" class="inp" value="<%= mail %>" placeholder="Entrez votre email" required><br>

            <label for="ps">Password</label><br>
            <input type="password" id="psw" name="psw" class="inp" value="<%= psw %>" placeholder="Entrez votre password" required><button type="button" id="show" onclick="shw()"></button><br>

            <input type="submit" class="bt" value="update">
        </form>
        <form action="DeleteAccountServlet" method="post" class="form">
          <hr>
          <input type="submit" class="bt" value="Delete Account">
        </form>
    </div>
  </nav>
  
  
   
	
  <script src="css/profScript.js"></script>

</body>
</html>
