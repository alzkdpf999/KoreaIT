import { Student } from "./Student.js";
import { StudentManager } from "./StudentManager.js";

function Careful() { // Function 프로토타입 객체가 부모
  //this ={}; 눈에는 안보이지만 자동적으로 만들어져 있음
  //속성 
  //return this 도 자동으로 해줌
}

Careful.prototype.empty = function () {
  let index;
  for (const num in arguments) {
    if (!arguments[num]) {
      index = num;
      break;
    }
    index = arguments.length+1;
  }
  
  return index;
}
Careful.prototype.emptyfocus = function (index) {
  let arr = ["ssn", "name", "kr", "en", "ma"];

  if (index == arr.length + 1) {
    console.log(arr[0]);
    return arr[0];
  } else {
    return arr[index];
  }
}
Careful.prototype.movefocus = function (id) {
  if (id == undefined) {
    document.querySelector("#ssn").focus();
  } else {
    document.querySelector(`#${id}`).focus();
  }
}
Careful.prototype.resigsterAfterInit = function () {
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
export { Careful };
