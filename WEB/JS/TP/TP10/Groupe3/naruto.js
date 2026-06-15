var posX=0;
var posY=0;
var mouvement=25;
var perso="naruto";
var direction="Down";
var prenom="";

var sasukeX = 300;
var sasukeY = 300;
var sasukeMouvement = 25;
var sasukeInterval = null;

var gameOver = false;

const CHANCE_ESQUIVE = 0.6;
const OSTS = [
  "assets/audio/strong-and-strike.mp3",
  "assets/audio/turn.mp3",
  "assets/audio/beautiful-green-wild-beast.mp3",
  "assets/audio/keisei-gyakuten.mp3",
  "assets/audio/the-raising-fighting-spirit.mp3"
]
let currentMusic = Math.floor(Math.random() * OSTS.length)
const MIN_ESQUIVES = 2

let esquivesRestantes

inputName.onkeyup = checkEnter;
inputName.oninput = checkName;
btnStart.onclick = start;
replayButton.onclick = restart
ost.onended = function () { if (!gameOver) playMusic() }

imgPoof1.addEventListener("animationend", function (event) {
  if (event.animationName === "poofAnim") {
    imgPoof1.classList.remove("animating")
  }
})
imgPoof2.addEventListener("animationend", function (event) {
  if (event.animationName === "poofAnim") {
    imgPoof2.classList.remove("animating")
  }
})

poofSFX.volume = 0.2
sasukeeee.volume = 0.15

function checkEnter(event) {
  if(event.key=="Enter" && inputName.value.length > 0) {
    start();
  }
}

function checkName() {
  if (inputName.value.length > 0) {
    document.getElementById("btnStart").removeAttribute("disabled");
  } else {
    document.getElementById("btnStart").disabled = true;
  }
}

function deplacement(event) {
  var grassWidth = grass.offsetWidth;
  var narutoWidth = imgNaruto.offsetWidth;
  var grassHeight = grass.offsetHeight;
  var narutoHeight = imgNaruto.offsetHeight;

  if(event.key=="ArrowDown" || event.key=="s") {
    if ((posY + mouvement + narutoHeight) < grassHeight) {
      posY+=mouvement;
      direction = "Down";
    }
  }
  else if(event.key=="ArrowUp" || event.key=="z") {
    if ((posY - mouvement) >= 0) {
      posY-=mouvement;
      direction = "Up";
    }
  }
  else if(event.key=="ArrowRight" || event.key=="d") {
    if ((posX + mouvement + narutoWidth) < grassWidth) {
      posX+=mouvement;
      direction = "Right";
    }
  }
  else if(event.key=="ArrowLeft" || event.key=="q") {
    if ((posX - mouvement) >= 0) {
      posX-=mouvement;
      direction = "Left";
    }
  }

  naruto.style.top=posY+"px";
  naruto.style.left=posX+"px";
  imgNaruto.setAttribute("src","assets/img/"+perso+direction+".png");
  verifierCollision();
}

function deplacer() {
  var grassWidth = grass.offsetWidth;
  var grassHeight = grass.offsetHeight;
  var sasukeWidth = imgSasuke.offsetWidth;
  var sasukeHeight = imgSasuke.offsetHeight;
  var directions = [];

  if ((sasukeY - sasukeMouvement) >= 0)                          directions.push("haut");
  if ((sasukeY + sasukeMouvement + sasukeHeight) < grassHeight)  directions.push("bas");
  if ((sasukeX - sasukeMouvement) >= 0)                          directions.push("gauche");
  if ((sasukeX + sasukeMouvement + sasukeWidth) < grassWidth)    directions.push("droite");

  if (directions.length === 0) return;

  var choix = directions[Math.floor(Math.random() * directions.length)];

  if (choix === "haut")   { sasukeY -= sasukeMouvement; direction = "Up"; }
  if (choix === "bas")    { sasukeY += sasukeMouvement; direction = "Down"; }
  if (choix === "gauche") { sasukeX -= sasukeMouvement; direction = "Left"; }
  if (choix === "droite") { sasukeX += sasukeMouvement; direction = "Right"; }

  sasuke.style.top = sasukeY + "px";
  sasuke.style.left = sasukeX + "px";
  imgSasuke.setAttribute("src","assets/img/sasuke"+direction+".png");
  verifierCollision();
}

function verifierCollision() {

if (gameOver) return;

  var narutoWidth = imgNaruto.offsetWidth;
  var narutoHeight = imgNaruto.offsetHeight;
  var sasukeWidth = imgSasuke.offsetWidth;
  var sasukeHeight = imgSasuke.offsetHeight;
  var tolerance = 30;

  var toucheX = Math.abs(posX - sasukeX) < (narutoWidth / 2 + sasukeWidth / 2 - tolerance);
  var toucheY = Math.abs(posY - sasukeY) < (narutoHeight / 2 + sasukeHeight / 2 - tolerance);

  if (toucheX && toucheY) {
    tentativeEsquive()
  }
}

function tentativeEsquive() {
  if (esquivesRestantes > 0) {
    esquivesRestantes--
    esquive()
  } else {
    const random = Math.random()
    if (random < CHANCE_ESQUIVE) {
      esquive()
    } else {
      gagner()
    }
  }
}

function esquive() {
  console.log("esquive")
  
  poof1.style.top = sasukeY - 35 + "px"
  poof1.style.left = sasukeX - 35 + "px"
  imgPoof1.classList.remove("animating")
  // reflow
  imgPoof1.offsetHeight
  imgPoof1.classList.add("animating")
  
  sasukeTP()
  
  poof2.style.top = sasukeY - 35 + "px"
  poof2.style.left = sasukeX - 35 + "px"
  imgPoof2.classList.remove("animating")
  // reflow
  imgPoof2.offsetHeight
  imgPoof2.classList.add("animating")

  poofSFX.pause()
  poofSFX.currentTime = 0
  poofSFX.play()
  
}

function sasukeTP() {
  let randomX = Math.random() * (grass.offsetWidth - imgSasuke.offsetWidth)
  let randomY = Math.random() * (grass.offsetHeight - imgSasuke.offsetHeight)
  
  sasukeX = Math.round(randomX / 25) * 25
  sasukeY = Math.round(randomY / 25) * 25
}

function gagner() {
  gameOver = true;
  clearInterval(sasukeInterval);

  victoryText.innerHTML = prenom + " a gagné !!!"

  narutoVictory.classList.add("show")
  victoryText.classList.add("show")
  replayButton.classList.add("show")

  document.body.onkeydown = null;

  ost.volume = 0.05
}

function playMusic() {
  ost.volume = 0.15
  if (ost.currentTime === 0 || ost.ended) {
    ost.src = OSTS[currentMusic]
    ost.play()
    let newMusic = Math.floor(Math.random() * OSTS.length)
    while (currentMusic === newMusic) newMusic = Math.floor(Math.random() * OSTS.length)
    currentMusic = newMusic
  }
}

function start() {
  prenom = document.getElementById("inputName").value;
  document.body.onkeydown = deplacement;
  naruto.setAttribute("title", prenom);
  formStart.style.display = "none";
  grass.style.display = "flex";

  sasuke.style.top = sasukeY + "px";
  sasuke.style.left = sasukeX + "px";

  sasukeInterval = setInterval(deplacer, 100);

  playMusic()

  esquivesRestantes = MIN_ESQUIVES
}

function restart() {
  gameOver = false
  narutoVictory.classList.remove("show")
  victoryText.classList.remove("show")
  replayButton.classList.remove("show")
  esquive()

  start()
}