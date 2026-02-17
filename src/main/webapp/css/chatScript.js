let ws = new WebSocket("ws://localhost:8080/eLearningPlateform/chat");

ws.onmessage = function(event){
    let box = document.querySelector(".msg");
    box.innerHTML += event.data + "<br>";
	// auto-scroll vers le bas
	box.scrollTop = box.scrollHeight;
}

function sendMessage(){
    let msg = document.querySelector(".inp");
    ws.send(msg.value);
    msg.value = "";
}