const background = document.getElementById("background");

const backgrounds = {
  michishirube: "assets/image/michishirube.jpg",
  acrossthevioletsky: "assets/image/acrossthevioletsky.webp",
  adamantinedreams: "assets/image/adamantinedreams.jpg",
  assassinationclassroom: "assets/image/assassinationclassroom.jpg",
  backToBusiness: "assets/image/backToBusiness.webp",
  blackcatcher: "assets/image/blackcatcher.jpg",
  domesticnakanojo: "assets/image/domesticnakanojo.jpg",
  drown: "assets/image/drown.jpg",
  hikarunara: "assets/image/hikarunara.jpg",
  kigeki: "assets/image/kigeki.webp",
  loveiswar: "assets/image/loveiswar.jpg",
  maomao: "assets/image/maomao.jpg",
  suzume: "assets/image/suzume.jpg",
  naruto: "assets/image/naruto.jpg",
  neongenesisevangelion: "assets/image/neongenesisevangelion.jpg",
  nevercomingback: "assets/image/nevercomingback.jpg",
  onepiece: "assets/image/onepiece.jpg",
  oshinoko: "assets/image/oshinoko.webp",
  rankingofkings: "assets/image/rankingofkings.jpg",
  renaicirculation: "assets/image/renaicirculation.jpg",
  Sincerly: "assets/image/Sincerly.jpg",
  isabella: "assets/image/isabellaslullaby.jpg",
  tanjirounouta: "assets/image/tanjirounouta.webp",
  tokyoghoul: "assets/image/tokyoghoul.jpg",
  YourName: "assets/image/YourName.webp",
  Violet:"assets/image/Violet.jpg",
  trollface: "assets/image/Trollface.png"

};

const secret = document.getElementById("VIOLETTO");
const retourSecret = document.getElementById("returnClassement");

const audios = document.querySelectorAll("audio");

let currentAudio;

background.style.backgroundImage = "url(assets/image/YourName.webp)";


secret.addEventListener("click", () => {

  document.querySelectorAll(".pagePrinc").forEach(el => {
    el.hidden = true;
  });

  document.querySelectorAll(".pageSec").forEach(el => {
    el.hidden = false;
    Violetto.style.display = "flex";
  });

});

retourSecret.addEventListener("click", () => {

  document.querySelectorAll(".pagePrinc").forEach(el => {
    el.hidden = false;
  });

  document.querySelectorAll(".pageSec").forEach(el => {
    el.hidden = true;
  });

  Violetto.style.display = "none";

});


audios.forEach(audio => {

  audio.addEventListener("play", () => {

    if (currentAudio === audio) return;

    if (currentAudio && currentAudio !== audio) {
      currentAudio.pause();
      currentAudio.currentTime = 0;
    }

    currentAudio = audio;

    const type = audio.getAttribute("data-anim");
    changeBackground(backgrounds[type]);
  });

  audio.addEventListener("pause", () => {

  });
});

function changeBackground(image) {
  background.classList.add("fade-out");

  setTimeout(() => {
    background.style.backgroundImage = `url(${image})`;
    background.classList.remove("fade-out");
  }, 300);
}