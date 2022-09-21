import {Student} from "./Student.js"

// Array를 이용하여 다수의 학생 관리
function StudentManager() {
  //this = {};
  this.array = [];
  //return this;
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


export { StudentManager };

