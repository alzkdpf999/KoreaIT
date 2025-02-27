import {Student} from "./Student.js"

// Array를 이용하여 다수의 학생 관리
function StudentManager() {
  //this = {};
  this.array = [];
  //return this;
}

StudentManager.prototype.initList=function(){
  let printList='';
  return function init_list(){
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

StudentManager.prototype.empty = function () {
  let index;
  for (const num in arguments) {
    if (!arguments[num]) {
      index = num;
      break;
    }
    index = arguments.length + 1;
  }

  return index;
}
StudentManager.prototype.getStudent = function () {
  return studentManager;
}
StudentManager.prototype.emptyfocus = function (index) {
  let arr = ["ssn", "name", "kr", "en", "ma"];

  if (index == arr.length + 1) {

    return arr[0];
  } else {
    return arr[index];
  }
}

StudentManager.prototype.movefocus = function (id) {
  if (id == undefined) {
    document.querySelector("#ssn").focus();
  } else {
    document.querySelector(`#${id}`).focus();
  }
}
StudentManager.prototype.resigsterAfterInit = function () {
  document.querySelector('#ssn').value = '';
  //이름
  document.querySelector('#name').value = '';
  //국어
  document.querySelector('#kr').value = '';
  //영어
  document.querySelector('#en').value = '';
  //수학
  document.querySelector('#ma').value = '';
}



StudentManager.prototype.initTagValue = function (id, val) {
  let arr = ["reg", "remove", "removeall", "sort"];
  let b = arr.filter(x => x == id)
  for (const value of arr) { //자바처럼 값을 가지고옴 
    if (b != value) {
      opener.document.querySelector(`#${value}`).value = ' ';
    } else {
      opener.document.querySelector(`#${id}`).value = val;
    }
  }
}

//학생 등록 
StudentManager.prototype.add =function(student){
    this.array.push(student);
}

//학생 전체목록 조회
StudentManager.prototype.list= function(arr){
  if(!arr) return this.array.slice(0,this.array.length);// 처음부터 끝까지 
  else return arr.array.slice();
  // return this.array.slice();// 처음부터 끝까지  같은 코딩
}

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

//삭제 true면 삭제하고 남은 학생들 false면 삭제한 학생
StudentManager.prototype.removefilter= function(ssn,name,bool=true){
  return this.array.filter(function(student){
    if(bool === true){
      let result = (student.name !== name || student.ssn !== ssn); 
    
      return result;
    }else{
      let result = (student.name === name && student.ssn === ssn); 
    
      return result;
    }
  })
}
//삭제한 학생 확인
StudentManager.prototype.removeStudent= function(ssn,name){
  return this.array.filter(function(student){

    let result = (student.name === name && student.ssn === ssn); 
    
    return result;
  })
}

StudentManager.prototype.listAll= function(printList){
  
  document.querySelector("#list").innerHTML = printList
}
//전체 검색./
StudentManager.prototype.searchAll = function(printList){

  document.querySelector("#list").innerHTML = printList
}



StudentManager.prototype.sorting = function (identy,arr) {
  switch (identy) {
    case "ssn":
      arr.array.sort(function (x, y) {
        return x.ssn - y.ssn;
      })
      break;
    case "name":
      arr.array.sort(function (x, y) {
        if (x.name.charCodeAt(0) == y.name.charCodeAt(0))
          return x.ssn - y.ssn;
        else return x.name.charCodeAt(0) - y.name.charCodeAt(0);

      })
      break;
    case "kr":
      arr.array.sort(function (x, y) {

        if (x.korean == y.korean)
          return x.ssn - y.ssn;
        else return y.korean - x.korean;
      })
      break;
    case "en":
      arr.array.sort(function (x, y) {
        if (x.english == y.english)
          return x.ssn - y.ssn;
        else return y.english - x.english;
      })
      break;
    case "math":
      arr.array.sort(function (x, y) {
        if (x.math == y.math)
          return x.ssn - y.ssn;
        else return y.math - x.math;
      })
      break;
    default:
      arr.array.sort(function (x, y) {
        if (x.getAverage() == y.getAverage())
          return x.ssn - y.ssn;
        else return y.getAverage() - x.getAverage();
      })
  }
}

StudentManager.prototype.sortPrinting = function (id,arr) {
  let init_list =StudentManager.prototype.initList();
  StudentManager.prototype.sorting(id,arr);

  let printList = init_list();
  let list = StudentManager.prototype.list(arr);
  for (let index = 0; index < list.length; index++) {
    printList = init_list(list[index]);
    StudentManager.prototype.searchAll(printList);
  }
}

export { StudentManager };

