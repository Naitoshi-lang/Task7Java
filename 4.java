function spy(fn) {
    function wrapper(...args) {
        wrapper.calls.push(args);
        return fn.apply(this, args);
    }
    
    wrapper.calls = [];
    return wrapper;
}

// Проверка
function add(a, b) {
    return a + b;
}

const spiedAdd = spy(add);

spiedAdd(1, 2);
spiedAdd(3, 4);
spiedAdd(5, 6);

console.log(spiedAdd.calls); // [[1, 2], [3, 4], [5, 6]]
console.log(spiedAdd(10, 20)); // 30
console.log(spiedAdd.calls); // [[1, 2], [3, 4], [5, 6], [10, 20]]
