<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign-up</title>
    <link rel="stylesheet" href="css/signStyle.css">
</head>
<body>

	<div class="logo"></div>

    <div class="box">
        <h1>Create an Account</h1>
        <form action="SignupServlet" method="post" class="form">
            <label for="fnm">First Name</label><br>
            <input type="text" id="fnm" name="fnm" class="inp" placeholder="Entrez votre nom" required><br>

            <label for="snm">Second Name</label><br>
            <input type="text" id="snm" name="snm" class="inp" placeholder="Entrez votre prenom" required><br>

            <label for="unm">Username</label><br>
            <input type="text" id="unm" name="unm" class="inp" placeholder="Entrez votre username" required><br>

            <label for="fnc">Function</label><br>
            <input type="text" id="fnc" name="fnc" class="inp" placeholder="Entrez votre travaille" required><br>

            <label for="city">City</label><br>
            <input type="text" id="city" name="city" class="inp" placeholder="Entrez votre ville" required><br>

            <label for="ml">Email</label><br>
            <input type="email" id="ml" name="ml" class="inp" placeholder="Entrez votre email" required><br>

            <label for="ps">Password</label><br>
            <input type="password" id="psw" name="psw" class="inp" placeholder="Entrez votre password" required><button type="button" id="show" onclick="shw()"></button><br>

            <input type="submit" class="btn" value="Create">
        </form>
        <p>You have an Account ? <a href="${pageContext.request.contextPath}/LoginIndex" class="link">Login Now !</a></p>
    </div>

    <script src="css/loginScript.js"></script>
</body>
</html>