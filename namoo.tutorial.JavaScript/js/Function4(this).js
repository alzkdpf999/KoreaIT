//객체안에서의 this는 자기 자신이지만 
//함수안에서는 window를 의미한다. this가 
let user = {
  name : "jack",
  age : 30,
  show : function () {
    console.log(`this 버전${this.name},${this.age}`);
    console.log(`user 버전${user.name},${user.age}`);
    console.log(this === user);
  }
}

user.show();

function doTask() {
  console.log("함수에서의 this는 window 객체이다");
  console.dir(this);
}
doTask();
doTask.call(user) //Object\

//하지만 요즘 이렇게 쓰는 경우는 없지만 
//전역함수를 메소드마냥 쓰고 싶다면 call을 쓴다.

function show1() {
  console.log(`${this.name},${this.age}`);
}
show1(); // undefined 잡힘

show1.call(user)
console.log("\n");

function addProperty(name,value) {
  this[name] = value;
}
// addProperty('ㅌㅌㅌ','ㄷㄷㄷㄷ');//이거는 window에 추가
// console.dir(this);
// console.log('ㅌㅌㅌ' in window);
addProperty.call(user,'gender','M'); //이거는 user에 추가
// ==  addPorperty.apply(user, ['gender' ,'M']); 39번째 줄과 똑같이 동작
console.dir(user);
//call과 apply는 기능은 같지만 차이점은 apply는 배열로 전달
console.log("\n");

//this를 영구히 변경 새로운 함수를 만들어 반환
let addUserProperty = addProperty.bind(user);
addUserProperty('address','대한민국');
addUserProperty('passwd',1234)
console.dir(user);