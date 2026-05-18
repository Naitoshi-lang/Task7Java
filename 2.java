function countdownWithTimeout(n) {
    let current = n;
    
    function tick() {
        console.log(current);
        
        if (current === 0) {
            console.log("Go!");
            return;
        }
        
        current--;
        setTimeout(tick, 1000);
    }
    
    tick();
}

// Проверка
countdownWithTimeout(5);
// 5, 4, 3, 2, 1, 0, Go!
