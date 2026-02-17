let score = document.getElementById("score");
let curent = parseInt(score.textContent);
let points = curent;
let back = document.querySelector(".back");
let front = document.querySelector(".front");
let ok = document.getElementById("msgbx");
let ms = document.getElementById("end").addEventListener("mouseenter", function(){
    
    back.style.display = "flex";
    
    points += 10;
    score.textContent = points;
});

function closeBx(){
    back.style.display = "none";
}

// ouverture
document.querySelectorAll(".course-card").forEach(card => {
  card.addEventListener("click", () => {
    // on récupère la page juste après la carte cliquée
    let page = card.nextElementSibling;
    page.classList.remove("hide");
  });
});

// fermeture
document.querySelectorAll(".course-page .close").forEach(button => {
  button.addEventListener("click", () => {
    let page = button.parentElement;
    page.classList.add("hide");
  });
});

