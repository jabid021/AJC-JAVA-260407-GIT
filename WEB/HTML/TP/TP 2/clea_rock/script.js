/*FOND MUSICAL*/

const fondRock = document.getElementById("fond_rock");
fondRock.volume = 0.05;

const startScreen = document.getElementById("start-screen");

startScreen.addEventListener("click", () => {
  fondRock.play();
  startScreen.remove();
});

const musicFond = document.getElementById("musicFond");
musicFond.addEventListener("click", () => {
  fondRock.pause();
  fondRock.currentTime = 0;
});

/* effet musique */

freddie.addEventListener("mouseover", (event) => {
  const freddieSound = new Audio("son/freddie-sound.mp3");
  freddieSound.volume = 0.2;
  freddieSound.play();
  freddieSound.currentTime = 0;
});

let credits = 0;
let coinInsere = false;
let creditValue = document.getElementById("credit-value");
guitar.addEventListener("mouseover", (event) => {
  const guitarMusic = new Audio("son/skull-guitar.mp3");
  guitarMusic.volume = 0.2;
  guitarMusic.play();
  guitarMusic.currentTime = 0;
  credits++;
  mettreAJourCredits();
});

/*coin*/

function mettreAJourCredits() {
  creditValue.textContent = credits;
}

const coin = document.getElementById("coin");
coin.addEventListener("click", (event) => {
  const coinSound = new Audio("son/coin.mp3");
  coinSound.volume = 0.2;
  coinSound.play();
  if (credits >= 1) {
    coinInsere = true;
    credits--;
    mettreAJourCredits();
  }
});

/*FULL GPT PCQ TROP GALERE*/

const svg = document.createElementNS("http://www.w3.org/2000/svg", "svg");
svg.style.cssText = "position:absolute;pointer-events:none;z-index:999;";
svg.innerHTML = `<rect class="march" rx="4"/>`;
document.body.appendChild(svg);

document.querySelectorAll("#tableau tbody tr").forEach((tr) => {
  tr.addEventListener("click", () => {
    const r = tr.getBoundingClientRect();
    svg.style.left = r.left + window.scrollX - 6 + "px";
    svg.style.top = r.top + window.scrollY - 5 + "px";
    svg.style.width = r.width + 6 + "px";
    svg.style.height = r.height + 6 + "px";
    svg.querySelector("rect").setAttribute("width", r.width + 3);
    svg.querySelector("rect").setAttribute("height", r.height + 3);
  });
});

/*----------------LIKES---------------*/

var coeur = document.querySelectorAll(".coeur");

for (c of coeur) {
  c.addEventListener("click", function (e) {
    console.log("Tu as cliqué sur un coeur !");
    e.stopPropagation();
    let divLike = this.parentElement.querySelector(".note-content");
    let like = Number(divLike.innerHTML);
    like++;
    divLike.textContent = like;
  });
}

/*SELECTION MUSIQUE*/

/* quand je sélectionne une musique le "select a track" devient le nom de la musique et le "-------" devient le nom du groupe
ensuite la barre track doit se lancer et le morceau doit jouer + le timer prend celui de la musique*/

let lignes = document.querySelectorAll("tr");
let audioSelectionne = null;
const tracktime = document.querySelector("#track_time");
const elapsedTime = document.querySelector("#elapsed_time");
const volume = document.querySelector("#volume");
const volumeValue = document.querySelector("#volume_value");
const rangeTrack = document.querySelector("#track_barre");

function buildDuration(duration) {
  let minutes = Math.floor(duration / 60); /*Arrondir une valeur*/
  let secondes = Math.floor(duration % 60);
  secondes = String(secondes).padStart(2, "0");
  return minutes + ":" + secondes;
}

function creerRickRoll() {
  const rickRoll = new Image(300, 300);
  rickRoll.src = "gif/rickRoll.gif";
  rickRoll.classList.add("rickroll");

  const x = Math.random() * (document.body.offsetWidth - 300);
  rickRoll.style.left = x + "px";

  const duree = 5 + Math.random() * 5;
  const delai = Math.random() * 1.5;
  rickRoll.style.animationDuration = duree + "s";
  rickRoll.style.animationDelay = "-" + delai + "s";

  document.body.appendChild(rickRoll);
}

function supprimerRickRolls() {
  document.querySelectorAll(".rickroll").forEach((el) => el.remove());
}

function lancerRickRolls() {
  if (!document.querySelector(".rickroll")) {
    for (let i = 0; i < 12; i++) {
      creerRickRoll();
    }
    audioSelectionne.addEventListener("ended", supprimerRickRolls, {
      once: true,
    });
  }
}

function mettreAJourDuree() {
  if (audioSelectionne.readyState >= 1) {
    tracktime.textContent = buildDuration(audioSelectionne.duration);
    rangeTrack.max = audioSelectionne.duration;
  } else {
    audioSelectionne.addEventListener(
      "loadedmetadata",
      function () {
        tracktime.textContent = buildDuration(audioSelectionne.duration);
        rangeTrack.max = audioSelectionne.duration;
      },
      { once: true },
    );
  }
}

function mettreAJourRange() {
  const val =
    ((rangeTrack.value - rangeTrack.min) / (rangeTrack.max - rangeTrack.min)) *
    100;
  rangeTrack.style.setProperty("--sx", val + "%");
}

function ajouterListenerTimeUpdate() {
  if (!nouvelAudio.dataset.listenerAdded) {
    nouvelAudio.addEventListener("timeupdate", function () {
      rangeTrack.value = this.currentTime;
      elapsedTime.textContent = buildDuration(this.currentTime);
      mettreAJourRange();
    });
    nouvelAudio.dataset.listenerAdded = "true";
  }
}

function gestionVolume() {
  volume.addEventListener("input", function () {
    if (audioSelectionne) {
      audioSelectionne.volume = this.value;
      volumeValue.textContent = Math.round(this.value * 100) + "%";
    }
  });
}

for (l of lignes) {
  l.addEventListener("click", function () {
    if (!coinInsere) {
      alert(
        "Insère une pièce dans le jukebox avant de sélectionner une musique !" +
          "Débrouilles toi pour trouver des crédits.. \nCrédit :" +
          credits,
      );
      return;
    }
    coinInsere = false;
    console.log("ligne sélectionnée");

    let song = this.querySelector(".song");

    let titre = song.querySelector(".titre").textContent;
    let chanteur = song.querySelector(".singer").textContent;
    track.textContent = titre;
    info_song.textContent = chanteur;

    nouvelAudio = song.querySelector("audio");

    if (audioSelectionne) {
      audioSelectionne.pause();
      audioSelectionne.currentTime = 0;
    }

    audioSelectionne = nouvelAudio;
    audioSelectionne.addEventListener("ended", stop, { once: true });
    elapsedTime.textContent = "0:00";
    rangeTrack.value = 0;
    mettreAJourRange();

    mettreAJourDuree();
    ajouterListenerTimeUpdate();

    if (titre == "Mystery Song") {
      lancerRickRolls();
    } else {
      supprimerRickRolls();
    }

    play();
  });
}

gestionVolume();
rangeTrack.addEventListener("input", function () {
  if (audioSelectionne) {
    audioSelectionne.currentTime = this.value;
    elapsedTime.textContent = buildDuration(this.value);
    mettreAJourRange();
  }
});

/* J'AI FAIS TOUTE SEULE OMG*/

play_btn.addEventListener("click", play);
pause_btn.addEventListener("click", pause);
stop_btn.addEventListener("click", stop);

titre_initial = track.textContent;
chanteur_initial = info_song.textContent;

function play() {
  if (audioSelectionne) {
    console.log("tu as cliqué sur le bouton play");
    vinyle_pause.style.setProperty("display", "none");
    pause_btn.style.setProperty("display", "flex");
    play_btn.style.setProperty("display", "none");
    audioSelectionne.play();
    audioSelectionne.volume = volume.value;
    fondRock.pause();
    coinInsere = false;
  }
}

function pause() {
  console.log("tu as cliqué sur le bouton pause");
  vinyle_pause.style.setProperty("display", "flex");
  play_btn.style.setProperty("display", "flex");
  pause_btn.style.setProperty("display", "none");

  play_btn.style.setProperty("opacity", "100%");
  audioSelectionne.pause();
}

function stop() {
  console.log("tu as cliqué sur le bouton stop");
  vinyle_pause.style.setProperty("display", "flex");
  play_btn.style.setProperty("display", "flex");
  pause_btn.style.setProperty("display", "none");
  audioSelectionne.pause();
  audioSelectionne.currentTime = 0;
  audioSelectionne = null;
  fondRock.currentTime = 0;
  fondRock.play();
  play_btn.style.setProperty("opacity", "50%");

  tracktime.textContent = "0:00";
  track.textContent = titre_initial;
  info_song.textContent = chanteur_initial;

  rangeTrack.value = 0;
  mettreAJourRange();
  document.querySelectorAll(".rickroll").forEach((el) => el.remove());
}
