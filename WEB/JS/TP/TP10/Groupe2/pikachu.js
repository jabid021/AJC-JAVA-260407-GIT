



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

 // Mettre à jour la position et l'image

pikachu.style.left = posX + "px";
pikachu.style.top = posY + "px";
imgPikachu.setAttribute(
  "src",
  "assets/img/" + pokemon + direction + ".png"
  );
}

