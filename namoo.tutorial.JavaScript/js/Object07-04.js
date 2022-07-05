let obj = new Object();
let obj1 ={
  name : 'jack',
  age : 30
}; //권장

let str = new Object('hack'); // String으로 알아서 바뀜
let num = new Object(10); // Number로 알아서 바뀜
console.log(str.constructor === String);
console.log(num.constructor === Number);

let obj2 = obj1.constructor(); // new Object();와 같은 코딩
console.log("obj2");
console.dir(obj2);
console.log("obj1");
console.dir(obj1);
console.log(obj1.toString());
console.log(obj1.toLocaleString());
console.clear();
console.log(obj1.hasOwnProperty('name'));
console.log('name' in obj1); // 위에와 같은 
console.log(obj1.propertyIsEnumerable('age')); //반복문을 사용해 열거할 수 있는지
for (const key in obj1) {
  if (Object.hasOwnProperty.call(obj1, key)) {
    console.log(`${key}: ${obj1[key]}`);
  }
}

console.log(Object.prototype.isPrototypeOf(obj1));

let str2 = new String('jack');
console.log(str2.toString());
console.log(str2.toLocaleString());

let now= new Date();
console.log(now.toString());
console.log(now.toLocaleString());

let num2 = new Number(10);
let num3 = num2.valueOf();
console.log(typeof num3);

//Object의 정적메소드
function Dog(){};
Dog.log = function(){
  console.log("dog");
};
Dog.log();

// 객체 복사
// 얕은 복사
let obj3 = obj1;
// 깊은 복사 아예 복제하는
let obj4 ={};
Object.assign(obj4, obj1); 

console.log(obj4);

// 객체의 키 목록 반환
let keys=Object.keys(obj1);
console.dir(keys);

//객체의 값 목록 반환
let value=Object.values(obj1);
console.dir(value);
//객체의 키,값 모두 반환 2차원 배열로 떨어짐 
let list=Object.entries(obj1);
console.dir(list);

