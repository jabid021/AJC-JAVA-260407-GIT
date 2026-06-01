



//1) saisir le nom du pokemon et valider avec le bouton ou Enter (le nom ne doit pas etre vide !)


// Récupération des éléments du DOM
let formStart=document.getElementById("formStart");
let inputName  = document.getElementById("inputName");

//id dans le html
let imgPikachu=document.getElementById("imgPikachu");
let pikachu=document.getElementById("pikachu");
let btnStart = document.getElementById("btnStart");
let grass = document.getElementById("grass");

//variables
let posX = 0;
let posY = 0;
let mouvement = 30;
let pokemon = "pikachu";
let direction = "Down";

//1) Activer le bouton seulement si le champ n'est pas vide

btnStart.disabled = true;
inputName.addEventListener("input", function () {
  btnStart.disabled = inputName.value.trim() === "";
});


// Démarrage via le bouton

btnStart.addEventListener("click", function () {
  demarrer();
});

// Démarrage via la touche Enter
inputName.addEventListener("keydown", function (event) {
  if (event.key === "Enter" && inputName.value.trim() !== "") {
    demarrer();
  }
});
 



/*2) Masquer la div formStart, Afficher la div grass, mettre le nom du pokemon en title sur la div pikachu*/

function demarrer() {
  pokemon = inputName.value.trim();
  formStart.style.display = "none";
  grass.style.display = "block";
  pikachu.setAttribute("title", pokemon);
  imgPikachu.setAttribute("src", "assets/img/" + pokemon + direction + ".png");


  // Lancer la musique dans la fonction démarrer
  let theme = document.getElementById("themePokemon");
    if (theme) {
      theme.play();
    }
  

// 3) Écouter les déplacements une fois le jeu démarré -→ dans la fonction démarrer

document.addEventListener("keydown", deplacer);
}


//4) Modifier la position de la div pikachu en fonction de la direction (+-30px par deplacement) et changer l'image


function deplacer(event) {
  if (event.key === "ArrowDown" || event.key === "s") {
    posY += mouvement;
    direction = "Down";
  } else if (event.key === "ArrowUp" || event.key === "z") {
    posY -= mouvement;
    direction = "Up";
  } else if (event.key === "ArrowRight" || event.key === "d") {
    posX += mouvement;
    direction = "Right";
  } else if (event.key === "ArrowLeft" || event.key === "q") {
    posX -= mouvement;
    direction = "Left";
  } else {
    return; 
  }


//5) Verifier que pikachu ne sort pas de la div grass

  if (posX < 0) posX = 0;
  if (posX > grass.offsetWidth  - pikachu.offsetWidth)  posX = grass.offsetWidth  - pikachu.offsetWidth;
  if (posY < 0) posY = 0;
  if (posY > grass.offsetHeight - pikachu.offsetHeight) posY = grass.offsetHeight - pikachu.offsetHeight;
var posX = 0;
var posY = 0;
var mouvement = 30;
var choix = ["pikachu", "coincoin"];
var pokemon = "pikachu";
var direction = "Down";
imgPikachu.setAttribute("src", "assets/img/" + pokemon + direction + ".png");


btnStart.onclick = Lancer;

 // Mettre à jour la position et l'image

pikachu.style.left = posX + "px";
pikachu.style.top = posY + "px";
imgPikachu.setAttribute(
  "src",
  "assets/img/" + pokemon + direction + ".png"
  );
}



inputName.onkeyup = function (event) {
  let name = inputName.value;
  if (name != "") {
    btnStart.disabled = false;
    console.log(event);
    if (event.key == "Enter") {
      Lancer();
    }
  }
  else {
    btnStart.disabled = true;
  }
}

function Lancer() {
  formStart.style.display = "none";
  //themePokemon.play();
  grass.style.display = "inline-block";
  pikachu.setAttribute("title", inputName.value);
  document.body.onkeydown = deplacement;
}


function deplacement(event) {
  if (event.key == "ArrowDown" || event.key == "s") {
    direction = "down";
    if (pikachu.style.top.toString().slice(0, -2) < 660) 
    {
      posY += mouvement;
    }
  }
  else if (event.key == "ArrowUp" || event.key == "z") {
    direction = "up";
    if (pikachu.style.top.toString().slice(0, -2) > 0) 
    {
      posY -= mouvement;
    }
  }
  else if (event.key == "ArrowRight" || event.key == "d") {
    direction = "right";
    if (pikachu.style.left.toString().slice(0, -2) < 660) 
    {
      posX += mouvement;
    }
  }
  else if (event.key == "ArrowLeft" || event.key == "q") {
    direction = "left";
    if (pikachu.style.left.toString().slice(0, -2) >  0) 
    {
      posX -= mouvement;
    }
  }

  changement();
  pikachu.style.top = posY + "px";
  pikachu.style.left = posX + "px";
  imgPikachu.setAttribute("src", "assets/img/" + pokemon + direction + ".png");
}


/*
function deplacement(event) {
  if (event.ctrlKey == true) {
    mouvement = 50;
  } else {
    mouvement = 30;
  }
  if (event.key == "ArrowDown"  event.key == "s") {
    if (posY<grass.offsetHeight - pikachu.offsetHeight){
    posY += mouvement;
    direction = "Down";
    }
  } else if (event.key == "ArrowUp"  event.key == "z") {
    if(posY>0){
    posY -= mouvement;
    direction = "Up";
    }
  } else if (event.key == "ArrowRight"  event.key == "d") {
    if (posX<grass.offsetWidth - pikachu.offsetWidth){
    posX += mouvement;
    direction = "Right";
}
  } else if (event.key == "ArrowLeft"  event.key == "q") {
    if(posX>0){
    posX -= mouvement;
    direction = "Left";
    }
  }

  pikachu.style.top = posY + "px";
  pikachu.style.left = posX + "px";
  imgPikachu.setAttribute("src", "assets/img/" + pokemon + direction + ".png");
}
*/

function changement(){ 
  let posPikaX = pikachu.style.left.toString().slice(0, -2);
  let posPikaY = pikachu.style.top.toString().slice(0, -2);
  if(posPikaX > 300 && posPikaX < 390 && posPikaY == 0){
    if(pokemon == "pikachu"){
      pokemon = "coincoin";
    }else{
      pokemon = "pikachu";
    }
  }
}
