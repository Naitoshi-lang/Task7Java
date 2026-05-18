// Способ 1: обычная функция, возвращающая функцию
function partialSum(a) {
    return function(b) {
        return a + b;
    };
}

const add5 = partialSum(5);
console.log(add5(3));  // 8
console.log(add5(10)); // 15

// Способ 2: через bind
function sum(a, b) {
    return a + b;
}

const add10 = sum.bind(null, 10);
console.log(add10(7));  // 17
console.log(add10(20)); // 30

// Способ 3: стрелочная функция
const partialSumArrow = a => b => a + b;
const add100 = partialSumArrow(100);
console.log(add100(25)); // 125
