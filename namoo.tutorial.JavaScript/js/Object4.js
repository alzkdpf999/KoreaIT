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
let student= new Student(18,'jack',10,10,10)
//prototype chain 확인
//student에는 hasOwnProperty 메소드가 존재하지 않지만 Object 프로토타입에서 상속받는다.

let exist = student.hasOwnProperty('ssn'); //있는지 없는지 확인
console.log(exist);
//프로토타입 객체를 접근하는 방법 2가지
console.log(Student.prototype);
console.log(student.__proto__);
console.log(Student.prototype===student.__proto__);

//프로토타입 객체는 constructor 프로퍼티를 갖는다
// constructor 프로퍼티는 객체의 입장에서 자신을 생성한 객체를 가리킨다.
console.log(Student.prototype.constructor === Student);
console.log(student.__proto__.constructor === Student);
console.log(student.constructor === Student);
console.log(Student.constructor === Function);

console.log(student.constructor === Student);//constructor는 반드시 일치하는 경우만
if(student.constructor === Student){
    console.log("Student로 부터 만들어진 인스턴스네여");
}

console.log(student instanceof Object); //약간 범위로 만들어지는 
console.log(student instanceof Student); //모두 다 true가 만들어짐 instanceof는 상속구조 범위로 체크
console.log("-------------------전 수업 내용들--------------------------");
console.log("\n");

function Animal(){
    this.name = '동물';
}
let aniaml= new Animal();
console.log(aniaml.name);

function Dog(){ }
let dog = new Dog();
console.log(dog instanceof Animal);//false

// 상속체인 만들기 위에서 부터 object -> Animal -> Dog로 만들기
Dog.prototype = new Animal(); // 1
let dog2 = new Dog(); //2
console.log(dog2.name); //3
console.log(dog2 instanceof Animal); //4  (1,2,3,4)는 일단  이해만 