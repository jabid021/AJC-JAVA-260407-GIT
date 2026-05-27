const iframe = document.getElementById('sc-player');
const player = SC.Widget(iframe);

const rowLol = document.querySelector('.level-5');

rowLol.addEventListener('mouseenter', () => {
    player.play();
});

rowLol.addEventListener('mouseleave', () => {
    player.pause();
});


const rows = document.querySelectorAll('tr');

const colors = {
    'level-0': '#a8e6a3',
    'level-1': '#c8f0a0',
    'level-2': '#f0e68c',
    'level-3': '#f5c97a',
    'level-4': '#9b7cf1',
    'level-5': '#e05252',
};

const defaultBg = '';

rows.forEach(row => {
    const level = row.className;

    row.addEventListener('mouseenter', () => {
        document.body.style.backgroundColor = colors[level];
    });

    row.addEventListener('mouseleave', () => {
        document.body.style.backgroundColor = defaultBg;
    });
});
