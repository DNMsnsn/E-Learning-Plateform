let index = 0;
let txt = document.querySelectorAll(".carousel-text");

setInterval(()=>{
    txt[index].classList.remove("active");
    index = (index + 1) % txt.length;
    txt[index].classList.add("active");
},3000);

function monte(){
    let rido = document.querySelector(".rido");
    rido.classList.add("monte");
}