function cs(){
    let nav = document.getElementById("cs");
    let van = document.getElementById("java");
    nav.style.display = "block";
    van.style.display = "none"
}

function jv(){
    let nav = document.getElementById("cs");
    let van = document.getElementById("java");
    nav.style.display = "none";
    van.style.display = "block"
}

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

