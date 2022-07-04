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

Student.prototype.schoolName = "Korea 중학교";

export {Student};