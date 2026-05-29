//1) saisir le nom du pokemon et valider avec le bouton ou Enter (le nom ne doit pas etre vide !)
//2) Masquer la div formStart, Afficher la div grass, mettre le nom du pokemon en title sur la div pikachu
//3) Gerer les deplacements, pouvoir bouger dans toutes les directions (haut,bas,gauche,droite) => les fleches et / ou zqsd
//4) Modifier la position de la div pikachu en fonction de la direction (+-30px par deplacement) et changer l'image
//5) Verifier que pikachu ne sort pas de la div grass

var posX = 0;
var posY = 0;
let pierreFoudreX = Math.random() * 670;
let pierreFoudreY = Math.random() * 670;
var mouvement = 15;
var pokemon = "pikachu";
var direction = "Down";
let score = 0;
let listeTaupiqueurs = [];
imgPikachu.setAttribute("src", "assets/img/" + pokemon + direction + ".png");



let inputName = document.getElementById("inputName");
let btnStart = document.getElementById("btnStart");
let frame = 1;
let frameMax = 4;
let frameInterval = null;

document.addEventListener("keyup", () => {
  if (inputName.value) {
    btnStart.removeAttribute("disabled");
  } else {
    btnStart.disabled = true;
  }

});


function StartGame() {


  let nom = inputName.value;
  formStart.hidden = true;
  compteur.hidden = false;
  nbcompteur.textContent = `x ${score}`;
  grass.style.display = "block";
  compteur.style.display = "flex";
  pikachu.setAttribute("title", nom);

  document.addEventListener("keydown", deplacement)

  themePokemon.play();
  setInterval(spawnTaupiqueur, 3000);

  setTimeout(() => {
    pierreFoudre.style.top = pierreFoudreY;
    pierreFoudre.style.left = pierreFoudreX;
    pierreFoudre.hidden = false;
  }, 5000);
}

btnStart.addEventListener("click", StartGame)

function evolve() {
  if (pokemon == "pikachu") {
    pokemon = "raichu";
    mouvement += 15;
    pierreFoudre.remove();
    pikachu.style.scale = 1.5;
  }
}

function spawnTaupiqueur() {

  console.log("nouvo chauve");
  let taupiqueur = document.createElement("div");

  let randomX = Math.random() * 650;
  let randomY = Math.random() * 650;

  taupiqueur.style.position = "absolute";
  taupiqueur.style.left = randomX + "px";
  taupiqueur.style.top = randomY + "px";

  taupiqueur.innerHTML = `<img class="imgTaupiqueur" src="assets/img/taupiqueur.png">`;

  grass.appendChild(taupiqueur);

  listeTaupiqueurs.push({
    element: taupiqueur,
    x: randomX,
    y: randomY

  });

  setTimeout(() => {
    taupiqueur.remove();
    listeTaupiqueurs = listeTaupiqueurs.filter(taupiq => taupiq.element !== taupiqueur);
  }, 5000);
}

function collision() {
  for (let taupiqueur of listeTaupiqueurs) {
    let distanceX = Math.abs(posX - taupiqueur.x);
    let distanceY = Math.abs(posY - taupiqueur.y);


    if (distanceX < 40 && distanceY < 40) {
      taupiqueur.element.remove();
      listeTaupiqueurs = listeTaupiqueurs.filter(taupiq => taupiq !== taupiqueur);
      score++;
      console.log("Score : " + score);
      nbcompteur.textContent = `x ${score}`;

    }

  }

}

function deplacement(event) {

  let newDirection = direction;

  if ((event.key == "ArrowDown" || event.key == "s") && posY < 650) {
    posY += mouvement;
    newDirection = "Down";
  } else if ((event.key == "ArrowUp" || event.key == "z") && posY > 0) {
    posY -= mouvement;
    newDirection = "Up";
  } else if ((event.key == "ArrowRight" || event.key == "d") && posX < 650) {
    posX += mouvement;
    newDirection = "Right";
  } else if ((event.key == "ArrowLeft" || event.key == "q") && posX > 0) {
    posX -= mouvement;
    newDirection = "Left";
  }
  if (newDirection !== direction) {
    frame = 1;
    direction = newDirection;
  }
  pikachu.style.top = posY + "px";
  pikachu.style.left = posX + "px";
  frame = (frame % frameMax) + 1;
  imgPikachu.setAttribute("src", `assets/img/${pokemon}/${direction}/${frame}.png`);

  if (
    posY < pierreFoudreY + 50 &&
    posY > pierreFoudreY - 50 &&
    posX < pierreFoudreX + 50 &&
    posX > pierreFoudreX - 50
  ) {
    evolve();
  }







  collision();

}
