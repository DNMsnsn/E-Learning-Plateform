<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>welcome</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/wlcmStyle.css">
</head>
<body>

	<div class="logo"></div>

    <nav class="rido">
        <nav class="carousel">
            <div class="carousel-text active">Bienvenue sur mon site 🚀</div>
            <div class="carousel-text">Apprends le Web, Java et C# facilement 💻</div>
            <div class="carousel-text">Crée tes propres projets interactifs 🎨</div>
            <div class="carousel-text">Amuse-toi à coder ! 😎</div>
        </nav>
        <button class="b1" onclick="monte()">Voir plus !</button>
    </nav>

    <section class="courses">
    <h2>Nos cours populaires</h2>
    <div class="course-list">
      <div class="course-card">
        <h3>Développement Web</h3>
        <p>Apprenez HTML, CSS, JavaScript et créez vos propres sites web modernes.</p>
      </div>
      <div class="course-card">
        <h3>Programmation Java</h3>
        <p>Maîtrisez la programmation orientée objet et construisez des applications robustes.</p>
      </div>
      <div class="course-card">
        <h3>Intelligence Artificielle</h3>
        <p>Découvrez le machine learning, le deep learning et l’IA appliquée.</p>
      </div>
    </div>
  </section>

  <a href="${pageContext.request.contextPath}/LoginIndex"><button class="b2">Login !</button></a>

    <script src="${pageContext.request.contextPath}/css/wlcmScript.js"></script>
</body>
</html>