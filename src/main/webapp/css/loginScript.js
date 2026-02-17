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

/* /// ICI LE CODE AVEC UN EVENT LISTENER ///

function show(){
    btn.addEventListener("click", () => {
        if(inp.type === "password"){
            inp.type = "text";
        } else{
            inp.type = "password";
        }
    });
}

    NB: dans une function on a pas besoin de faire un eventListener
    ajouter a cela quand on a un bouton de ce genre dans un formulaire
    on doit preciser son type="button" si non il le prend pour un submit
*/