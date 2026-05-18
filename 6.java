function withRetry(fn, attempts, delay) {
    return function(...args) {
        let currentAttempt = 0;
        
        function tryExecute(resolve, reject) {
            try {
                const result = fn.apply(this, args);
                resolve(result);
            } catch (error) {
                currentAttempt++;
                console.log(`Попытка ${currentAttempt} не удалась: ${error.message}`);
                
                if (currentAttempt >= attempts) {
                    reject(error);
                } else {
                    setTimeout(() => tryExecute(resolve, reject), delay);
                }
            }
        }
        
        return new Promise(tryExecute);
    };
}

// Проверка
let counter = 0;
const unstableFn = () => {
    counter++;
    if (counter < 3) {
        throw new Error(`Ошибка в попытке ${counter}`);
    }
    return "Успех!";
};

const retriedFn = withRetry(unstableFn, 5, 1000);

retriedFn().then(console.log).catch(console.error);
// Попытка 1 не удалась
// Попытка 2 не удалась
// Успех!
