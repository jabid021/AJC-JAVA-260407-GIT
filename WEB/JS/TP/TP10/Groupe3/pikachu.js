//1) saisir le nom du pokemon et valider avec le bouton ou Enter (le nom ne doit pas etre vide !)
//2) Masquer la div formStart, Afficher la div grass, mettre le nom du pokemon en title sur la div pikachu
//3) Gerer les deplacements, pouvoir bouger dans toutes les directions (haut,bas,gauche,droite) => les fleches et / ou zqsd
//4) Modifier la position de la div pikachu en fonction de la direction (+-30px par deplacement) et changer l'image
//5) Verifier que pikachu ne sort pas de la div grass

var posX=0;
var posY=0;
var mouvement=25;
var pokemon="pikachu";
var direction="Down";
var prenom="";
imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");

inputName.onkeyup=checkEnter;
inputName.oninput=checkName;
btnStart.onclick=start;


function checkEnter(event)
{
  if(event.key=="Enter" && inputName.value.length > 0) {
    start();
  }
}

function checkName()
{
  if (inputName.value.length > 0) {
    document.getElementById("btnStart").removeAttribute("disabled");
  } else {
    document.getElementById("btnStart").disabled = true;
  }
}

function deplacement(event)
{
  var grassWidth = grass.offsetWidth;
  var pikaWidth = imgPikachu.offsetWidth;
  var grassHeight = grass.offsetHeight;
  var pikaHeight = imgPikachu.offsetHeight;

  if(event.key=="ArrowDown" || event.key=="s" )
  {
    if ((posY + mouvement + pikaHeight) < (grassHeight)) {
      posY+=mouvement;
      direction = "Down";
    }
  }
  else if(event.key=="ArrowUp" || event.key=="z")
  {
    if ((posY - mouvement) >= 0) {
      posY-=mouvement;
      direction = "Up";
    }
  }

  else if(event.key=="ArrowRight" || event.key=="d" )
  {
    if ((posX  + mouvement + pikaWidth) < (grassWidth)) {
      posX+=mouvement;
      direction = "Right";
    }
  }

  else if(event.key=="ArrowLeft" || event.key=="q")
  {
    if ((posX - mouvement) >= 0) {
      posX-=mouvement;
      direction = "Left";
    }
  }

  pikachu.style.top=posY+"px";
  pikachu.style.left=posX+"px";
  imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");

}

function start() {
  prenom = document.getElementById("inputName").value;

  document.body.onkeydown = deplacement;
  pikachu.setAttribute("title",prenom);

  formStart.style.display = "none";
  grass.style.display = "block";

}