// console.log(new Number(115.3447).toFixed(2));
'use strict'//을 쓰면 8진수 16진수 지원을 안함 변수 선언안하는것도 안되게 바꿈
// 엄격하게 검사함
console.log(10);
// console.log(05);
// console.log(0X11);
// user = 'jack';
// console.log(user); 

console.log(Number.MAX_VALUE);
// toFixed 파라미터가 없으면 소수점 자리 없이 나타냄
console.log(new Number(111.5101919).toFixed(3));
console.log(111.5101919.toFixed(3));

let strNum = "1004";
//parseInt(strNum);
let num =Number(strNum); //new는 객체를 생성 그냥은 형변환을 해줌
console.log(typeof num);

