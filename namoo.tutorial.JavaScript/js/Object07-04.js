let obj = new Object();
let obj1 ={}; //권장

let str = new Object('hack');
let num = new Object(10);
console.log(str.constructor === String);
console.log(num.constructor === Number);