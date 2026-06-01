



//1) saisir le nom du pokemon et valider avec le bouton ou Enter (le nom ne doit pas etre vide !)


let posX = 330;
let posY = 30;
let mouvement = 30;

let animal = select_animal.value;
let direction = "Down";

let crottes = [];
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


function start_game() {
  console.log('Start game')
  posX = 330;
  posY = 30;
  direction = "Down";
  animal = select_animal.value;
  genre=select_sex.value;
  pikachu.style.display = "block";

  pikachu.style.left = posX + "px";
  pikachu.style.top = posY + "px";

  imgPikachu.setAttribute("src", "assets/img/" + genre + animal + direction + ".png");
  alert("Ramassez toutes les crottes avant de rentrer !");
  formStart.style.display = "none";
  grass.style.display = "block";
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
      y: y
    });
    grass.innerHTML +=
      `<div class="crotte" id="crotte_${i}" style="top:${y}px; left:${x}px;">
    <img src="assets/img/caca.png" alt="" width="30px" height="30px">
  </div>`;
  }
  document.body.onkeydown = deplacement;
}

inputName.onkeyup = verif_name;
btnStart.onclick = start_game;

////////////////////////// DEPLACEMENT //////////////////////////
function deplacement(event) {

  if (event.key == "ArrowDown" || event.key == "s") {

    if (posY < grass.offsetHeight - pikachu.offsetHeight) {
      posY += mouvement;
      direction = "Down";
    }
  }
  else if (event.key == "ArrowUp" || event.key == "z") {

    if (posY >= mouvement) {
      posY -= mouvement;
      direction = "Up";
    }

  }
  else if (event.key == "ArrowRight" || event.key == "d") {

    if (posX < grass.offsetWidth - pikachu.offsetWidth) {
      posX += mouvement;
      direction = "Right";
    }
  }
  else if (event.key == "ArrowLeft" || event.key == "q") {

    if (posX >= mouvement) {
      posX -= mouvement;
      direction = "Left";
    }

  }

  pikachu.style.top = posY + "px";
  pikachu.style.left = posX + "px";
  imgPikachu.setAttribute("src", "assets/img/" + genre + animal + direction + ".png");
  ramasser_crotte();
}

function ramasser_crotte() {
  const perso = document.getElementById("pikachu");
  const crottes = document.querySelectorAll(`.crotte`);

  const rectPerso = perso.getBoundingClientRect();


  console.log('Crottes restantes');
  console.log(document.querySelectorAll('.crotte').length)
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
      console.log(crottes)
      console.log(document.querySelectorAll('.crotte').length + " crottes restantes")
      compteurCrotte.innerHTML = `${5 - (document.querySelectorAll('.crotte').length)}/5`;
      if (document.querySelectorAll('.crotte').length == 0) {
        setTimeout(() => {
          alert('Vous avez ramassé toutes les crottes ! Retournez maintenant au refuge !');
        }, 500);
      }
    }
  }

  // Rentrer si y'a plus de crotte
  if (crottes.length == 0) {
    rentrer_shelter();
  }
}

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
    pikachu.style.display = "none";
    console.log('rentré ! ')
    //pikachu.remove();
    setTimeout(() => {
      alert('Vous etes rentré au Shelter !');
    }, 500);
    document.body.onkeydown = null;
    formStart.style.display = "block";
    grass.style.display = "none";
    compteurCrotte.innerHTML = `0/5`;
  }
}



