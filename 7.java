const user = {
    name: "Алексей",
    sayHi() {
        console.log(`Привет, я ${this.name}`);
    }
};

// Неправильно (this потеряется)
// setTimeout(user.sayHi, 1000); // "Привет, я undefined"

// Правильно через bind
setTimeout(user.sayHi.bind(user), 1000); // "Привет, я Алексей"

// Другие способы
setTimeout(() => user.sayHi(), 1000);     // через стрелочную функцию
setTimeout(function() { user.sayHi(); }, 1000); // через обёртку
