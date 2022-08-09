import { Student } from "./Student.js";
import { StudentManager } from "./StudentManager.js";

function Careful() { // Function 프로토타입 객체가 부모
  //this ={}; 눈에는 안보이지만 자동적으로 만들어져 있음
  //속성 
  //return this 도 자동으로 해줌
}
let printList = null;
let list = null;


let studentManager = new StudentManager();
let init_list = studentManager.initList();
Careful.prototype.empty = function () {
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
Careful.prototype.getStudent = function () {
  return studentManager;
}
Careful.prototype.emptyfocus = function (index) {
  let arr = ["ssn", "name", "kr", "en", "ma"];

  if (index == arr.length + 1) {

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

Careful.prototype.sortPrinting = function (id) {

  studentManager.sorting(id);

  printList = init_list();
  list = studentManager.list();
  for (let index = 0; index < list.length; index++) {
    printList = init_list(list[index]);
    studentManager.searchAll(printList);
  }
}

Careful.prototype.initTagValue = function (id, val) {
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



Careful.prototype.openCenter = function (url, name, width, height) {

  let left = (screen.availWidth - width) / 2;
  let top = (screen.availHeight - height) / 2;
  let option = "letf=" + left + ",top=" + top + ",width=" + width + ",height=" + height;
  let pop = window.open(url, name, option);
  pop.addEventListener("beforeunload", function (event) {
    const ssn = this.opener.document.querySelector('#ssn').value;
    //이름
    const name = this.opener.document.querySelector('#name').value;
    //국어
    const kr = parseInt(this.opener.document.querySelector('#kr').value);
    //영어
    const en = parseInt(this.opener.document.querySelector('#en').value);
    //수학
    const ma = parseInt(this.opener.document.querySelector('#ma').value);

    if (this.opener.document.querySelector('#reg').value == "reg") {

      studentManager.add(new Student(ssn, name, kr, en, ma))
      let array = studentManager.array;
      printList = init_list();
      list = studentManager.list();
      for (let index = 0; index < list.length; index++) {
        printList = init_list(list[index])
        studentManager.searchAll(printList);
      }
      if (ssn && name && kr && en && ma) Careful.prototype.resigsterAfterInit();
    } else if (this.opener.document.querySelector('#remove').value == "remove") {
      printList = init_list();
      const removeName = document.querySelector('#name').value;
      const removeSsn = document.querySelector('#ssn').value;
      if (removeName && removeSsn) Careful.prototype.resigsterAfterInit();
      let unDeletedStudent = studentManager.removefilter(removeSsn, removeName);
      // let deletedStudent= studentManager.removefilter(removeSsn,removeName,false);
      let out = studentManager.array.findIndex(i => i.ssn == removeSsn && i.name == removeName);

      if (out != -1) studentManager.array.splice(out, 1);

      for (let index = 0; index <= unDeletedStudent.length; index++) {
        if (unDeletedStudent.length == 0) {
          document.querySelector("#list").innerHTML = printList
        } else {
          if (index == unDeletedStudent.length) {
            continue;
          } else {
            printList = init_list(unDeletedStudent[index])
            studentManager.searchAll(printList);
          }
        }
      }
    } else if (this.opener.document.querySelector('#removeall').value == "removeall") {
      printList = init_list();
      document.querySelector("#list").innerHTML = printList
      studentManager.array.length = 0;
    } else {
      let sortVal = this.opener.document.querySelector('#sort').value;
      switch (sortVal) {

        case "ssn":
          Careful.prototype.sortPrinting("ssn");
          break;
        case "name":
          Careful.prototype.sortPrinting("name");
          break;
        case "kr":
          Careful.prototype.sortPrinting("kr");
          break;
        case "en":
          Careful.prototype.sortPrinting("en");
          break;
        case "math":
          Careful.prototype.sortPrinting("math");
          break;
        case "avg":
          Careful.prototype.sortPrinting("avg");
          break;
      }
    }
    this.opener.document.querySelector('#reg').value = '';
    this.opener.document.querySelector('#remove').value = '';
    this.opener.document.querySelector('#removeall').value = '';
    this.opener.document.querySelector('#sort').value = '';
  })
}


Careful.prototype.closePop = function (id) {
  let val = document.querySelector(`#${id}`).value;
  if (id.includes('sort')) {
    Careful.prototype.initTagValue("sort", val)
  } else {
    Careful.prototype.initTagValue(id, val);
  }
  self.close();
}
export { Careful };

