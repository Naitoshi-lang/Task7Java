function once(fn) {
    let called = false;
    let result;
    
    return function(...args) {
        if (!called) {
            result = fn.apply(this, args);
            called = true;
        }
        return result;
    };
}

// Проверка
const init = once(() => {
    console.log("Инициализация...");
    return 42;
});

console.log(init()); // "Инициализация..." и 42
console.log(init()); // 42 (без вывода "Инициализация...")
console.log(init()); // 42
