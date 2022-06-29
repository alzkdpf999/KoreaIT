//함수 선언문
function showMessage() {
  console.log("hello JavaScript");
}
function showMessage2(message) {
  if (message === undefined) {
    // throw new Error("입력하세요")
    message = "Hello. you want to send your message to others plz input message"
  }
  console.log(message);
  //return은 있다고 생각하면 된다 return undefined;가 나온다.
}
//함수 호출
showMessage();
showMessage2("halo");
showMessage2();
//함수 표현식
const a = showMessage();
console.log(a);
console.clear();

function show(sender, asd) {
  if (sender == undefined || asd === undefined) return;

  console.log(`${sender} : ${asd}`);
}
show("방그리", 'dgd');
show('sd')

function showMessage3(message = '3') {
  console.log(message);
}
showMessage3(123); //123
showMessage3(); //3

function sum(...args) {
  let result = 0
  for (const value of args) {
    result += value;
  }
  console.log(result);

}
sum();
sum(1, 2, 3);
