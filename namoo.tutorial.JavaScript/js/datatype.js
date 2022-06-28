// 동적 Typing
let age=20;
console.log(typeof age);
let weight = 57.9;
age = "김기정";
console.log(age);
console.log(typeof age);

console.log(10/0);
console.log(-10/0);
console.log(typeof 10/0) //NaN
console.log(age/10);
console.log(typeof age/10); //NaN
console.log(typeof Infinity); //number
let name='111';
let name2='222';
console.log('111'+'바보'+age);
let message=`문자열입니다.${age}${weight+50}   ${50+20}`;
console.log(message);

console.log("*++++++++++++++++++++++++++++++++++++++++++++++*");
console.log(true);
console.log(false);
console.log(10 >5);
console.log("*++++++++++++++++++++++++++++++++++++++++++++++*");
// 0,'', undefined, null;는 다 false
console.log(typeof null); //object라고 나오지만 이거는 오류이다는 썰
console.log(typeof undefined); //undefined
// {} 객체 표현할때 씀 객체 타입(레퍼런스 타입)
// 객체 리터럴(값) 표현식 사용
let person = {
  name : 'Hack ',
  age: 10,
  weight: 67.8
};
console.log(person.name);
console.log(person.age);
console.log(person['weight']);
