import {Student} from "./Student.js"
let init_list=initList();
let cnt=increamentCount()
function increamentCount() {
  //은닉화시켜주면서 인스턴스 변수처럼 쓰게 하고 싶을 때 
    let count = 0;
    return function(){ 
      if(arguments.length ==1){
        count=0;
        return count;
      }
      else return ++count;
      
    }
  }
function initList(){
  let printList='';
  return function(){
    if(arguments.length==0){
      printList=`<ul>
  <li>학번</li><li>이름</li><li>국어</li><li>영어</li><li>수학</li><li>평균</li>
</ul>`;
      return printList;
    }else{
      for(let i=0; i<arguments.length;i++){
      printList += `<ul>`
      printList += `<li>${arguments[i].ssn}</li><li>${arguments[i].name}</li><li>${arguments[i].korean}</li><li>${arguments[i].english}</li><li>${arguments[i].math}</li><li>${arguments[i].getAverage()}</li>`;
      printList += `</ul>`;
      }
      return printList;
      
    }
  }
}
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
/* StudentManager.prototype.find = function(ssn){
  for (const student of this.array) {
    if(student.ssn === ssn)
    return student;
    
  }
  // 더 쉬운 방법
  
  return  this.array.find(function(student){
    
    return student.ssn == ssn;
  });
} */

StudentManager.prototype.filter= function(ssn){
  return this.array.filter(function(student){
    return student.ssn == ssn;
  })
}

StudentManager.prototype.idfilter= function(name){
  return this.array.filter(function(student){
    return student.name == name;
  })
}

//삭제
StudentManager.prototype.removefilter= function(ssn,name){
  return this.array.filter(function(student){

    let result = (student.name !== name || student.ssn !== ssn); 
    
    return result;
  })
}


//등록 함수
/*function resigsterList(list) {
  let ul= document.createElement("ul");
  for (const index of list) {
    for (const key in index) {
      let li= document.createElement("li");
      let p = document.createElement("br")
      if(typeof(index[key]) === 'function' || key == 'schoolName'){
        continue;
      }
      let txt = document.createTextNode(index[key]);
      li.appendChild(txt);
      ul.appendChild(li);
      
    }
    let txt = document.createTextNode(`${index.getAverage()}`);
    let li = document.createElement("li")
    li.appendChild(txt);
    ul.appendChild(li);
  }
  document.querySelector("#list").appendChild(ul);
}
//부분 서치
function listAll(list){
  let printList=init_list(list);
  document.querySelector("#list").innerHTML = printList
}
//전체 검색./
function searchAll(index){
  let printList=init_list(index);
  document.querySelector("#list").innerHTML = printList
}
*/
export {StudentManager};