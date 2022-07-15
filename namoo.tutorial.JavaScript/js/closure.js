//Closure
//치명적인 결함
let count = 0;

function increamentCount() {
  return ++count;
}
let c= increamentCount();
console.log("카운트 : " +c);

count =100;
console.log(increamentCount());
console.log(increamentCount());
console.log(increamentCount());
console.log(increamentCount());
console.log(increamentCount());