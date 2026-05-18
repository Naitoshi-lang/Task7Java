function debounce(fn, ms) {
    let timeoutId = null;
    
    return function(...args) {
        // Очищаем предыдущий таймер
        if (timeoutId) {
            clearTimeout(timeoutId);
        }
        
        // Устанавливаем новый таймер
        timeoutId = setTimeout(() => {
            fn.apply(this, args);
        }, ms);
    };
}

// Проверка
const sayHello = () => console.log("Hello!");
const debouncedHello = debounce(sayHello, 1000);

debouncedHello(); // вызов сбросит таймер
debouncedHello(); // снова сбросит
debouncedHello(); // только этот вызов сработает через 1 секунду

