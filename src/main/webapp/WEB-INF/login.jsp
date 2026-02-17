<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Log-in</title>
    <link rel="stylesheet" href="css\loginStyle.css">
</head>
<body>

	<div class="logo"></div>

    <nav class="hdr">
        <a href="${pageContext.request.contextPath}/Index"><button class="b1"></button></a>
    </nav>

    <div class="box">
        <h1>Hello Friend !</h1>
        <form action="LoginServlet" method="post" class="form" autocomplete="off">
            <label for="unm">Username</label><br>
            <input type="text" id="unm" class="inp" name="unm" placeholder="Entrez votre username" autocomplete="off" required><br>

            <label for="psw">Password</label><br>
            <input type="password" id="psw" class="inp" name="psw" placeholder="Entrez votre password" autocomplete="new-password" required><button type="button" id="show" onclick="shw()"></button><br>

            <input type="submit" class="btn" value="Login">    
        </form>
        <p>Don't have an Account ? <a href="${pageContext.request.contextPath}/SignupIndex" class="link">Create One !</a></p>
    </div>
    
    <script src="css\loginScript.js"></script>
</body>
</html>