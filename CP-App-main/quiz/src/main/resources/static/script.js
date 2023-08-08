// START TIMER--TEST TRIAL AT 10 SECONDS THEN PROMPT TIMES UP--MOVES TO RESULT PAGE
function startTimer(duration) {
    let timeCount = document.getElementById('timeCount');
    let timer = duration;

    counter = setInterval(function () {
        if (timer <= 0) {
            clearInterval(counter); // CLEAR COUNTER-----------
            timeCount.textContent = "TIME'S UP!!";
            submitQuiz();
        }

        timeCount.textContent = timer ;
        timer--;
    }, 1000);
}

document.addEventListener("DOMContentLoaded", function() {
    startTimer(100);
});

function submitQuiz() {
    document.querySelector("form").submit();
}
