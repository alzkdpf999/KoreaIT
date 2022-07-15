//Closure
// "use strict";
//치명적인 결함


function increamentCount() {
//은닉화시켜주면서 인스턴스 변수처럼 쓰게 하고 싶을 때 
  let count = 0;
  return function(){
    return ++count;
  }
}
let counter= increamentCount();
let c=counter();

console.log("카운트 : " +c);

count =100;
console.log(counter());
console.log(counter());
console.log(counter());
console.log(counter());
console.log(counter());