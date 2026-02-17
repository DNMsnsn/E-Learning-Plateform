
let setbut = document.querySelector(".setbut");
let setbox = document.querySelector(".back");

function setshw(){
    if(setbox.style.display === "none" || setbox.style.display === ""){
        setbox.style.display = "block";
    }else{
        setbox.style.display = "none";
    }
}

let inp = document.getElementById("psw");
let btn = document.getElementById("show");

function shw(){
    if(inp.type === "password"){
        inp.type = "text";
        btn.style.backgroundImage = "url(css/hide.png)";
    } else{
        inp.type = "password";
        btn.style.backgroundImage = "url(css/eye.png)";
    }
}

let updt = document.querySelector(".bt");
let unm = document.querySelector(".unm");
let fnc = document.querySelector(".func");
let city = document.querySelector(".city");
let unmInp = document.getElementById("unm");
let fncInp = document.getElementById("fnc");
let cityInp = document.getElementById("city");

function update(event){
    event.preventDefault();
    
    if(unmInp.value.trim() !== ""){
        unm.textContent = unmInp.value;
        setbox.style.display = "none"
    }

    if(fncInp.value.trim() !== ""){
        fnc.textContent = fncInp.value;
        setbox.style.display = "none"
    }

    if(cityInp.value.trim() !== ""){
        city.textContent = cityInp.value;
        setbox.style.display = "none"
    }
}


let slct = document.querySelectorAll(".myAvatar");
let bp = document.querySelector(".select");
let pic = document.querySelector(".pic");
let av = document.querySelector(".av");
slct.forEach(img => {
    img.addEventListener("click", function(){
        slct.forEach(i => {
            i.classList.remove("selected");
            this.classList.add("selected");

            bp.addEventListener("click", ()=>{
                pic.src = this.src;
				av.value = this.src;
				setbox.style.display = "none";
                
            });
        });
    });
    
});

let pub = document.querySelector(".pub");

function pubShow(){
    if(pub.style.display === "none" || pub.style.display === ""){
        pub.style.display = "flex";
    }
}

function pubClose(){
    if(pub.style.display === "flex"){
        pub.style.display = "none";
    }
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
