const tag = document.createElement('script');
tag.src = "https://w.soundcloud.com/player/api.js";
document.head.appendChild(tag);

tag.onload = () => {
    const iframe = document.getElementById('sc-player');
    const player = SC.Widget(iframe);

    const rowLol = document.querySelector('.level-5');

    rowLol.addEventListener('mouseenter', () => {
        player.play();
    });

    rowLol.addEventListener('mouseleave', () => {
        player.pause();
    });
};