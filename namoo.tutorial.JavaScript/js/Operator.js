let str="100";
let num=100;
console.log(str + num ); //num이 문자열로 동작 출력 :100100
console.log(str * num ); //str이 숫자로 동작 출력 :10000
console.log(str / num ); //str이 숫자로 동작 출력 :1

// ==(동등비교) ===(일치비교 자료형까지 비교)
console.log(str == num); //true
console.log(str === num); // false
console.log(str !== num); // true

console.log(0 == false); //true
console.log(0 === false); //false
console.log('' == false); //true
console.log('' === false); //false
if(10){
  console.log("aa");
}

console.log(null == undefined);//true
console.log(null === undefined);//false

let a=10;
console.log(a++);
console.log(a);
console.log(++a);
