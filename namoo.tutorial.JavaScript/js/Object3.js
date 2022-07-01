// 생성사 함수(객체 생성을 위한 템플릿)
// 프로토타입을 이용한 메소드 공유
function Student(ssn,name,korean,english,math){ // Function 프로토타입 객체가 부모
    //this ={}; 눈에는 안보이지만 자동적으로 만들어져 있음
    //속성 
    this.ssn=ssn;
    this.name=name;
    this.korean=korean;
    this.english=english;
    this.math=math;
    //return this 도 자동으로 해줌
}
//메소드를 프로토타입에 추가
Student.prototype.getsum = function(){
    return this.korean + this.english + this.math;
}
Student.prototype.getAverage = function(){
    return this.getsum()/3 ;
}
Student.prototype.toString = function(){
    return `${this.ssn},${this.name},${this.korean},${this.english},${this.math},${this.getsum()},${this.getAverage()}`;
} //모든 속성값 나오게 만듬

//공유하기 위한 속성 추가
Student.prototype.schoolName = "Korea 중학교";

// student 는 object 프로토타입 객체가 부모
let student= new Student(18,'jack',10,10,10);
console.log(student.name);
console.log(student['ssn']);
console.log(student.schoolName);
//console.log(Student.prototype.schoolName);

console.dir(student);
/* let student2=Student(10,20,30,40,50) //new를 써야한다.
console.log(student2); undefined
 */

console.log(student.getsum());
console.log(student.toString());
    
console.log(student instanceof Student);//true
console.log(student instanceof Object);//true

//자바스크립트에는 미리 정의된 생성자 함수들이 존재하는데
//애네들을 표준 내장 객체(생성자 함수)라 한다.
// Object, String, Number, Math, Date, Array, Regexp ........

let obj = new Object();  // 왼쪽과 같은 식 let obj = {};
obj.name='11';
obj.age=11;
console.dir(obj);

let message = new String("JavaScript");
let message2= "Java Script";

let a = message2.indexOf('S');
console.log(a);

