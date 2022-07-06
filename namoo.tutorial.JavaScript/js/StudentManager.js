import {Student} from "./Student.js"
// Array를 이용하여 다수의 학생 관리
function StudentManager() {
  //this = {};
  this.array = [];
  //return this;
}
//학생 등록 
StudentManager.prototype.add =function(student){
  if(student == undefined){
    console.log("학생을 입력해주세요");
  }else{ 
    this.array.push(student);
    console.dir(this.array);
  }
}
//학생 전체목록 조회
StudentManager.prototype.list= function(){
  return this.array.slice(0,this.array.length);// 처음부터 끝까지 
  // return this.array.slice();// 처음부터 끝까지  같은 코딩
}
//학생 번호로 조회
StudentManager.prototype.find = function(ssn){
  /* for (const student of this.array) {
    if(student.ssn === ssn)
    return student;
    
  } */
  // 더 쉬운 방법
  
  return  this.array.find(function(student){
    return student.ssn == ssn;
  });
}

export {StudentManager};