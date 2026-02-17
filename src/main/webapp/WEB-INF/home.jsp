<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.DAO.Course" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="css/homeStyle.css">
</head>
<body>

	

  <%
  	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	
	if(session.getAttribute("unm") == null) {
		response.sendRedirect("login.jsp");
		return;
	}
 	%>
 	
 	<div class="logo"></div>

    <nav class="hdr">
	    <a href="courses"><button class="b1"></button></a>
	    <a href="HomeIndex"><button class="bb"></button></a>
	    <a href="profile"><button class="bc"></button></a>
	    <a href="ChatIndex"><button class="cr"></button></a>
  	</nav>

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
    </div>

    <div class="course-page hide">
      <button class="close" onclick="closePage()"></button>
      <nav class="score">
      <%
    	HttpSession docSession = request.getSession();
    	Integer score = (Integer) docSession.getAttribute("score");
   	  %>
        <h3>XP : </h3> <h3 id="score"><%= score %></h3>
      </nav>
      <nav class="page-content">
        <h1><%= c.getTitle() %></h1>
        <p><%= c.getDescription() %></p>
        <p><%= c.getContent() %></p>
        <h3><%= c.getUname() %></h3>
      </nav>
      <nav class="end container" id="end">
        This Course Ends Here !
      </nav>
    </div>
    <%	} } %>
  </div>

    <nav class="back">
        <nav class="front">
        	<form action="ScoreUpdateServlet" method="post">
	            <p>Congratulations<br>
	            You've Finished the Course ! <br></p>
	            <input type="submit" id="msgbx" onclick="closeBx()" value="OK">
            </form>
        </nav>
    </nav>

    <script src="css/homeScript.js"></script>

</body>
</html>