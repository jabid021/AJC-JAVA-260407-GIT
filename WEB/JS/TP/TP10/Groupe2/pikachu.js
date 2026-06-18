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

let rectGrass = grass.getBoundingClientRect();

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
  compteurCrotte.innerHTML = `0/5`;
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



  bords = {
    left: rectPerso.left - rectGrass.left,
    right: rectPerso.right - rectGrass.left,
    top: rectPerso.top - rectGrass.top,
    bottom: rectPerso.bottom - rectGrass.top
  }
  console.log("Bord LEFT du perso par rapport a grass : " + (bords.left));
  console.log("Bord bas du perso par rapport a grass : " + (bords.bottom));
  console.log("Bord RIGHT du perso par rapport a grass : " + (bords.right));
  console.log("Bord HAUT du perso par rapport a grass : " + (bords.top));

  console.log("-------------")

  console.log("Bord LEFT du grass par rapport a grass : " + grass.offsetHeight);
  console.log("Bord bas du grass par rapport a grass : " + grass.offsetHeight);
  console.log("Bord RIGHT du grass par rapport a grass : " + grass.offsetHeight);
  console.log("Bord HAUT du grass par rapport a grass : " + grass.offsetHeight);


  console.log("distance = " + (bords.left - mouvement));

  if (event.key == "ArrowDown" || event.key == "s") {
    if (bords.bottom < grass.offsetHeight) {
      if (mouvement > grass.offsetHeight - bords.bottom) {
        posY += grass.offsetHeight - bords.bottom;
        console.log("mouvement > distance");
        console.log("posY = " + posY);
      } else {
        posY += mouvement;
      }

      direction = "Down";
    }
  } else if (event.key == "ArrowUp" || event.key == "z") {
    if (bords.top >= 0) {
      if (mouvement > bords.top) {
        posY -= bords.top;
      } else {
        posY -= mouvement;
      }

      direction = "Up";
    }
  } else if (event.key == "ArrowRight" || event.key == "d") {
    if (bords.right < grass.offsetWidth) {

      if (mouvement > grass.offsetHeight - bords.right) {
        posX += grass.offsetHeight - bords.right;
        console.log("mouvement > distance");
        console.log("posX = " + posX);
      } else {
        posX += mouvement;
      }
      direction = "Right";
    }
  } else if (event.key == "ArrowLeft" || event.key == "q") {
    if (bords.left >= 0) {
      if (mouvement > bords.left) {
        posX -= bords.left;
      } else {
        posX -= mouvement;
      }
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
}

//COLLISION//

function collision_buisson() {
  const perso = document.getElementById("pikachu");
  const buissons = document.querySelectorAll(".buisson");

  const rectPerso = perso.getBoundingClientRect();



  var bords_persos = {
    left: rectPerso.left - rectGrass.left,
    right: rectPerso.right - rectGrass.left,
    top: rectPerso.top - rectGrass.top,
    bottom: rectPerso.bottom - rectGrass.top
  }

  for (let i = 0; i < buissons.length; i++) {
    const rectBuisson = buissons[i].getBoundingClientRect();
    const margin = 5;

    var bords_buisson = {
      left: rectBuisson.left - rectGrass.left,
      right: rectBuisson.right - rectGrass.left,
      top: rectBuisson.top - rectGrass.top,
      bottom: rectBuisson.bottom - rectGrass.top
    };

    if (
      bords_persos.left < bords_buisson.right &&
      bords_persos.right > bords_buisson.left &&
      bords_persos.top < bords_buisson.bottom &&
      bords_persos.bottom > bords_buisson.top
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