//1) saisir le nom du pokemon et valider avec le bouton ou Enter (le nom ne doit pas etre vide !)

let posX = 330;
let posY = 30;
let mouvement = 30;

let animal = select_animal.value;
let direction = "Down";

let crottes = [];
let buissons = [];
//imgPikachu.setAttribute("src", "assets/img/" + animal + direction + ".png");
let genre = select_sex.value;

function verif_name(event) {
  console.log(inputName.value);
  console.log(event);
  if (inputName.value != "") {
    btnStart.disabled = false;
    if (event.key == "Enter") {
      start_game();
    }
  } else {
    btnStart.disabled = true;
  }
}

const div_crottes = document.getElementsByClassName("div-crottes")[0];
audioTheme = document.getElementById("theme");

function start_game() {
  console.log("Start game");

  audioTheme.volume = 0.3;
  audioTheme.play();

  posX = 330;
  posY = 30;
  direction = "Down";
  animal = select_animal.value;
  genre = select_sex.value;
  pikachu.style.display = "block";

  pikachu.style.left = posX + "px";
  pikachu.style.top = posY + "px";

  document.getElementById("nomPerso").textContent = inputName.value;

  imgPikachu.setAttribute(
    "src",
    "assets/img/" + genre + animal + direction + ".png",
  );
  alert("Ramassez toutes les crottes avant de rentrer !");
  formStart.style.display = "none";
  imgDog.style.display = "none";
  imgDuck.style.display = "none";
  qwack.style.top = "5%";
  grass.style.display = "block";
  div_crottes.style.display = "block";
  /*console.log(inputName);
  console.log(btnStart);
  console.log(animal);*/

  var title = inputName.value + " et son " + animal;
  pikachu.setAttribute("title", title);

  /// Generer des crottes aléatoirement
  for (let i = 0; i < 5; i++) {
    const x = Math.random() * (grass.offsetWidth - 100);
    const y = Math.random() * (grass.offsetHeight - 100);

    crottes.push({
      x: x,
      y: y,
    });
    grass.innerHTML += `<div class="crotte" id="crotte_${i}" style="top:${y}px; left:${x}px;">
    <img src="assets/img/caca.png" alt="" width="30px" height="30px">
  </div>`;
  }

  /// Generer des buissons aléatoirement
  for (let i = 0; i < 7; i++) {
    const x = Math.random() * (grass.offsetWidth - 100);
    const y = Math.random() * (grass.offsetHeight - 100);
    while ((x, y) === crottes[i]) {
      x = Math.random() * (grass.offsetWidth - 100);
      y = Math.random() * (grass.offsetHeight - 100);
    }

    buissons.push({
      x: x,
      y: y,
    });

grass.innerHTML += `
<div class="buisson" style="top:${y}px; left:${x}px; width:30px; height:30px;">
  <img src="assets/img/buisson.png" alt="" width="30px" height="30px">
</div>`;;
  }
  document.body.onkeydown = deplacement;
}

inputName.onkeyup = verif_name;
btnStart.onclick = start_game;

////////////////////////// DEPLACEMENT //////////////////////////
function deplacement(event) {
  const ancienneX = posX;
  const ancienneY = posY;

  var rectPerso = pikachu.getBoundingClientRect();
  var rectGrass = grass.getBoundingClientRect();


  if (event.key == "ArrowDown" || event.key == "s") {
    if (posY + mouvement < grass.offsetHeight - pikachu.offsetHeight) {
      if (mouvement > (rectPerso.bottom - rectGrass.top)) {
        posY += mouvement - (grass.offsetHeight - rectPerso.bottom + rectGrass.top);
      } else {
        posY += mouvement;
      }

      direction = "Down";
    }
  } else if (event.key == "ArrowUp" || event.key == "z") {
    if (posY >= mouvement) {
      posY -= mouvement;
      direction = "Up";
    }
  } else if (event.key == "ArrowRight" || event.key == "d") {
    if (posX + mouvement < grass.offsetWidth - pikachu.offsetWidth) {

      if (mouvement > (rectPerso.right - rectGrass.left)) {
        posX += mouvement - (grass.offsetWidth - rectPerso.right + rectGrass.left);
      } else {
        posX += mouvement;
      }
      direction = "Right";
    }
  } else if (event.key == "ArrowLeft" || event.key == "q") {
    if (posX >= mouvement) {
      posX -= mouvement;
      direction = "Left";
    }
  }

  pikachu.style.top = posY + "px";
  pikachu.style.left = posX + "px";

  if (collision_buisson()) {
    posX = ancienneX;
    posY = ancienneY;

    pikachu.style.top = posY + "px";
    pikachu.style.left = posX + "px";
  }

  imgPikachu.setAttribute(
    "src",
    "assets/img/" + genre + animal + direction + ".png",
  );
  ramasser_crotte();

  console.log("Coin droit du perso par rapport a grass : " + (rectPerso.right - rectGrass.left));
}

//COLLISION//

function collision_buisson() {
  const perso = document.getElementById("pikachu");
  const buissons = document.querySelectorAll(".buisson");

  const rectPerso = perso.getBoundingClientRect();

  for (let i = 0; i < buissons.length; i++) {
    const rectBuisson = buissons[i].getBoundingClientRect();
    const margin = 20;

    const hitbox = {
      left: rectBuisson.left + margin,
      right: rectBuisson.right - margin,
      top: rectBuisson.top + margin,
      bottom: rectBuisson.bottom - margin
    };

    if (
      rectPerso.left < hitbox.right &&
      rectPerso.right > hitbox.left &&
      rectPerso.top < hitbox.bottom &&
      rectPerso.bottom > hitbox.top
    ) {
      return true;
    }
  }

  return false;
}

audioCrotte = new Audio("assets/audio/fart.mp3");
audioVictoire = new Audio("assets/audio/victory.mp3");

function ramasser_crotte() {
  const perso = document.getElementById("pikachu");
  const crottes = document.querySelectorAll(`.crotte`);

  const rectPerso = perso.getBoundingClientRect();

  console.log("Crottes restantes");
  console.log(document.querySelectorAll(".crotte").length);
  for (let index = 0; index < crottes.length; index++) {
    const crotte = crottes[index];
    const rectCrotte = crotte.getBoundingClientRect();
    if (
      rectPerso.left < rectCrotte.right &&
      rectPerso.right > rectCrotte.left &&
      rectPerso.top < rectCrotte.bottom &&
      rectPerso.bottom > rectCrotte.top
    ) {
      crotte.remove();
      audioCrotte.play();
      console.log(crottes);
      console.log(
        document.querySelectorAll(".crotte").length + " crottes restantes",
      );
      compteurCrotte.innerHTML = `${5 - document.querySelectorAll(".crotte").length}/5`;
      if (document.querySelectorAll(".crotte").length == 0) {
        setTimeout(() => {
          alert(
            "Vous avez ramassé toutes les crottes ! Retournez maintenant au refuge !",
          );
        }, 500);
        audioTheme.pause();
        audioVictoire.play();
      }
    }
  }

  // Rentrer si y'a plus de crotte
  if (crottes.length == 0) {
    rentrer_shelter();
  }
}

audioPop = new Audio("assets/audio/pop.mp3");

function rentrer_shelter() {
  console.log(pikachu, centrePokemon);
  const rectPerso = pikachu.getBoundingClientRect();
  const rectCentrePokemon = centrePokemon.getBoundingClientRect();
  const marge = 50;

  if (
    rectPerso.left < rectCentrePokemon.right - marge &&
    rectPerso.right > rectCentrePokemon.left + marge &&
    rectPerso.top < rectCentrePokemon.bottom - marge &&
    rectPerso.bottom > rectCentrePokemon.top + marge
  ) {

    audioPop.currentTime = 0;
    audioPop.play();

    pikachu.style.display = "none";
    audioTheme.pause();
    console.log("rentré ! ");

    setTimeout(() => {
      alert("Vous etes rentré au Shelter !");
    }, 500);

    document.body.onkeydown = null;

    formStart.style.display = "";
    imgDog.style.display = "";
    imgDuck.style.display = "";

    grass.style.display = "none";
    div_crottes.style.display = "none";
  }
}