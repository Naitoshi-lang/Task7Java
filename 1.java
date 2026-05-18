function countdown(n) {
    let current = n;
    
    const intervalId = setInterval(() => {
        console.log(current);
        
        if (current === 0) {
            clearInterval(intervalId);
            console.log("Go!");
        }
        
        current--;
    }, 1000);
}

// Проверка
countdown(5);
// 5, 4, 3, 2, 1, 0, Go!
