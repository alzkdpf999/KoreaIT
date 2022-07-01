// function expression hoisting 불가 (함수 표현식)
let someDo= function() {
  console.log("hi");
}
someDo();

let someDo1=someDo;
someDo1();

//이것도 가능함
function xxxx() {
  console.log('xxxx');
}
someDo1=xxxx;
someDo1();
console.log(someDo);
//-------------------------


//callback 함수
function whatYourName(name,callback) {
  console.log(`hello, ${name}`);
  callback();
}
whatYourName('김기정',function(){
  console.log("특정작업을 연속적으로 수행한 후 함수 종료됩니다...");
});

let array=[1,2,3,4,5,6];
array.forEach(function(value,index ,arr){
  console.log(`${value} + ${index}`);
  console.log(arr);
});

//  arrow function
let simple =function(){
  console.log("arrow function");
}
let simple2= () => {
  console.log("arrow function");
}
let simple3 = ()=>console.log("arrow function");
simple = (x,y)=> x+y;
console.log(simple(3,5));

simple = message => console.log(message); //인자가 하나면 소괄호 생략 가능 
simple('xxx');

(function howMuch(){
  console.log("go home");
})(); //selfcall
//-----------------------------------------------------------------
//동적 함수 생성
let sum2 =new Function('x','y','return x+y');
console.log(sum2(10,20));