const audio = document.getElementById("audio");
const playBtn = document.getElementById("play");
const seekBar = document.getElementById("seek");
const current = document.getElementById("current");
const duration = document.getElementById("duration");
const repeatBtn = document.getElementById("repeat");
const shuffleBtn = document.getElementById("shuffle");

let isPlaying = false;
let isRepeat = false;
let isShuffle = false;

// Format seconds into mm:ss
function formatTime(seconds) {
  let mins = Math.floor(seconds / 60);
  let secs = Math.floor(seconds % 60);
  return `${mins}:${secs < 10 ? "0" + secs : secs}`;
}

// Update seek bar
audio.addEventListener("loadedmetadata", () => {
  seekBar.max = Math.floor(audio.duration);
  duration.textContent = formatTime(audio.duration);
});

audio.addEventListener("timeupdate", () => {
  seekBar.value = Math.floor(audio.currentTime);
  current.textContent = formatTime(audio.currentTime);
});

seekBar.addEventListener("input", () => {
  audio.currentTime = seekBar.value;
});

// Play / Pause
playBtn.addEventListener("click", () => {
  if (isPlaying) {
    audio.pause();
    playBtn.textContent = "▶️";
  } else {
    audio.play();
    playBtn.textContent = "⏸️";
  }
  isPlaying = !isPlaying;
});

// Repeat
repeatBtn.addEventListener("click", () => {
  isRepeat = !isRepeat;
  audio.loop = isRepeat;
  repeatBtn.style.color = isRepeat ? "lightgreen" : "white";
});

// Shuffle
shuffleBtn.addEventListener("click", () => {
  isShuffle = !isShuffle;
  shuffleBtn.style.color = isShuffle ? "lightgreen" : "white";
});

// Dummy buttons for prev/next
document
  .getElementById("prev")
  .addEventListener("click", () => alert("Previous song"));
document
  .getElementById("next")
  .addEventListener("click", () => alert("Next song"));
