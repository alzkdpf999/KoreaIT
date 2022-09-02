import { Student } from "./Student.js";
import { StudentManager } from "./StudentManager.js";
import { Careful } from "./Careful.js"
function StudentApp() {

}
let studentManager = new StudentManager();

studentManager.movefocus();
let printList;
let out, kr, ssn, name, en, ma;
let list;
const regExp = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\" |a-z|A-Z |ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g;
const regNum = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\" |0-9]/g;
const regLimit = /[^0-9]/g;
const regZero = /^0[0-9]+$/g;

let init_list = studentManager.initList();
//이름 검색
document.querySelector("#search").addEventListener("click", function (event) {
  printList = init_list();
  let searchAllManager = studentManager;
  const findname = document.querySelector('#name').value;
  let findStudentname = searchAllManager.idfilter(findname);
  if (findStudentname.length == 0) {
    document.querySelector("#list").innerHTML = printList
  } else {
    for (let index = 0; index < findStudentname.length; index++) {
      printList = init_list(findStudentname[index]);
      searchAllManager.listAll(printList);
    }
  }
})

//학번 조회
document.querySelector("#smsearch ").addEventListener("click", function (event) {
  printList = init_list();
  let searchStudentManager = studentManager;
  const findSsn = document.querySelector('#ssn').value;
  let findStudent = searchStudentManager.filter(findSsn);
  if (findStudent == 0) {
    document.querySelector("#list").innerHTML = printList
  } else {
    for (let index = 0; index < findStudent.length; index++) {
      printList = init_list(findStudent[index]);
      searchStudentManager.listAll(printList);
    }
  }
})
//등록 부분
//등록 팝업
document.querySelector("#register").addEventListener("click", function (event) {
  let h4 = document.createElement('h4');
  let option;
  let txt;
  //학번
  document.querySelector(".ok").value = '';
  ssn = document.querySelector('#ssn').value;
  //이름
  name = document.querySelector('#name').value;
  //국어
  kr = parseInt(document.querySelector('#kr').value);
  //영어
  en = parseInt(document.querySelector('#en').value);
  //수학
  ma = parseInt(document.querySelector('#ma').value);
  if (!ssn || !name || !kr || !en || !ma) { // 둘 중 하나 입력 안할때 
    option = "#errcase";
    document.querySelector(option).setAttribute("style", "display: flex;");
    txt = document.createTextNode("정보를 전부 입력해주세요.");
  } else {
    option = "#case";
    document.querySelector(option).setAttribute("style", "display: flex;");
    let btn1 = document.createElement('button');
    txt = document.createTextNode(`${ssn}학번 ${name}님을 등록하시겠습니까?`);
    let txt1 = document.createTextNode(`등록`);
    btn1.className = 'btn btn-dark del';
    btn1.setAttribute("type", "button");
    btn1.setAttribute("id", "reg");
    btn1.appendChild(txt1);
    document.querySelector(".Allbtn").prepend(btn1);
  }
  h4.className = 'h4';
  h4.appendChild(txt);
  document.querySelector(option).appendChild(h4);
})
//등록 부분

//전체검색
document.querySelector("#allSearch").addEventListener("click", function (event) {
  printList = init_list();
  let list = studentManager.list()
  for (let index = 0; index < list.length; index++) {
    printList = init_list(list[index]);
    studentManager.searchAll(printList);
  }
})

//전체 삭제
document.querySelector("#removeall").addEventListener("click", function (event) {
  let h4 = document.createElement('h4');
  let option;
  let txt;
  let empty = studentManager.array.length;
  document.querySelector("#removeall").setAttribute("disabled", "disabled");
  document.querySelector(".ok").value = "#removeall"

  if (empty != 0) { //이름 학번 둘다 입력
    option = "#case";
    document.querySelector(option).setAttribute("style", "display: flex;");
    let btn1 = document.createElement('button');
    txt = document.createTextNode(`전체 삭제하시겠습니까?`);
    let txt1 = document.createTextNode(`삭제`);
    btn1.className = 'btn btn-dark del';
    btn1.setAttribute("type", "button");
    btn1.setAttribute("id", "delAll");
    btn1.appendChild(txt1);
    document.querySelector(".Allbtn").prepend(btn1);
  } else {
    option = "#errcase";
    document.querySelector(option).setAttribute("style", "display: flex;");
    txt = document.createTextNode(`이미 학생이 존재하지 않습니다.`);
  }
  h4.className = 'h4';
  h4.appendChild(txt);
  document.querySelector(option).appendChild(h4);
})

//삭제 팝업
document.querySelector("#remove").addEventListener("click", function (event) {
  let h4 = document.createElement('h4');
  let option;
  let txt;
  //학번 
  ssn = document.querySelector('#ssn').value;
  //이름
  name = document.querySelector('#name').value;
  document.querySelector("#remove").setAttribute("disabled", "disabled");
  document.querySelector(".ok").value = "#remove"
  let out = studentManager.array.findIndex(i => i.ssn == ssn && i.name == name);

  if (!ssn || !name) { // 둘 중 하나 입력 안할때 
    option = "#errcase";
    document.querySelector(option).setAttribute("style", "display: flex;");
    txt = document.createTextNode("학번과 이름을 입력해주세요.");
  } else if (out != -1) { //이름 학번 둘다 입력
    option = "#case";
    document.querySelector(option).setAttribute("style", "display: flex;");
    let btn1 = document.createElement('button');
    txt = document.createTextNode(`${ssn}학번 ${name}님을 삭제하시겠습니까?`);
    let txt1 = document.createTextNode(`삭제`);
    btn1.className = 'btn btn-dark del';
    btn1.setAttribute("type", "button");
    btn1.setAttribute("id", "del");
    btn1.appendChild(txt1);
    document.querySelector(".Allbtn").prepend(btn1);
  } else {
    option = "#errcase";
    document.querySelector(option).setAttribute("style", "display: flex;");
    txt = document.createTextNode(`${ssn}학번 ${name}님이 존재하지 않습니다.`);
  }
  h4.className = 'h4';
  h4.appendChild(txt);
  document.querySelector(option).appendChild(h4);
})

document.querySelector(".cancle").addEventListener("click", function (event) {
  let result = document.querySelector(".ok").value;
  document.querySelector("#case").removeAttribute("style");
  let h4 = document.querySelector(".h4");
  document.querySelector("#case").removeChild(h4);
  let btn = document.querySelector(".del");
  document.querySelector(".Allbtn").removeChild(btn);
  if (result != '') document.querySelector(result).removeAttribute("disabled");
})

document.querySelector(".ok").addEventListener("click", function (event) {
  let result = document.querySelector(".ok").value;
  document.querySelector("#errcase").removeAttribute("style");
  let h4 = document.querySelector(".h4");
  document.querySelector("#errcase").removeChild(h4);
  if (result != '') document.querySelector(result).removeAttribute("disabled");
  let index;
  console.log(result);
  if (result == "") {

    index = studentManager.empty(ssn, name, kr, en, ma);
    let select = studentManager.emptyfocus(index);
    studentManager.movefocus(select);
  } else {
    if (result != "#sort" || result != "#removall") {
      index = studentManager.empty(ssn, name);
      if (index <= 2) {

        let select = studentManager.emptyfocus(index);
        studentManager.movefocus(select);
      }
    }
  }
})
//삭제 부분 

//정렬 부분
document.querySelector("#sort").addEventListener("click", function (event) {
  let h4 = document.createElement('h4');
  document.querySelector(".ok").value = "#sort"
  document.querySelector("#sort").setAttribute("disabled", "disabled");
  let option;
  let txt;
  let empty = studentManager.array.length;
  if (empty == 0) { //이름 학번 둘다 입력
    option = "#errcase";
    document.querySelector(option).setAttribute("style", "display: flex;");
    txt = document.createTextNode(`학생이 존재하지 않습니다.`);
  }else{
    option = "#sortcase"
    document.querySelector(option).setAttribute("style", "display: flex;");
    txt = document.createTextNode("정렬 방법을 선택주세요.");

  }
  h4.className = 'h4';
  h4.appendChild(txt);
  document.querySelector(option).appendChild(h4);
})
document.querySelector("#ss").addEventListener("click",function(event){
  studentManager.sortPrinting("ssn");
})
document.querySelector("#ns").addEventListener("click",function(event){
  studentManager.sortPrinting("name");
})
document.querySelector("#ks").addEventListener("click",function(event){
  studentManager.sortPrinting("kr");
})
document.querySelector("#es").addEventListener("click",function(event){
  studentManager.sortPrinting("en");
})
document.querySelector("#ms").addEventListener("click",function(event){
  studentManager.sortPrinting("math");
})
document.querySelector("#as").addEventListener("click",function(event){
  studentManager.sortPrinting("avg");
})
/*
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
*/
//정렬 부분 


// 입력 부분
document.querySelector("#ssn").addEventListener("input", function (event) {

  ssn = document.querySelector("#ssn").value;
  if (regExp.test(ssn)) {

    document.querySelector("#ssn").value = ssn.replace(regExp, "");
  }
})

document.querySelector("#name").addEventListener("input", function (event) {
  name = document.querySelector("#name").value;
  if (regNum.test(name)) {
    document.querySelector("#name").value = name.replace(regNum, "");
  }
})

document.querySelector("#kr").addEventListener("input", function (event) {
  kr = document.querySelector("#kr").value;
  if (regLimit.test(kr)) {
    document.querySelector("#kr").value = kr.replace(regLimit, '');
  }
  if (regZero.test(kr)) {
    document.querySelector("#kr").value = kr.replace(regZero, '0');
  }
  if (kr >= 100) document.querySelector("#kr").value = 100;
})
document.querySelector("#en").addEventListener("input", function (event) {
  en = document.querySelector("#en").value;
  if (regLimit.test(en)) {
    document.querySelector("#en").value = en.replace(regLimit, '');
  }
  if (regZero.test(en)) {
    document.querySelector("#en").value = en.replace(regZero, '0');
  }
  if (en >= 100) document.querySelector("#en").value = 100;
})
document.querySelector("#ma").addEventListener("input", function (event) {
  ma = document.querySelector("#ma").value;
  if (regLimit.test(ma)) {
    document.querySelector("#ma").value = ma.replace(regLimit, '');
  }
  if (regZero.test(ma)) {
    document.querySelector("#ma").value = ma.replace(regZero, '0');
  }
  if (ma >= 100) document.querySelector("#ma").value = 100;
})
// 입력 부분

//동적으로 생성된 버튼 동작 부분
document.querySelector("#case").addEventListener('click', function (event) {
  let h4 = document.querySelector(".h4");
  let btn;
  //삭제
  if (event.target && event.target.id == 'del') {
    btn = document.querySelector("#del");
    document.querySelector(".Allbtn").removeChild(btn);
    document.querySelector("#case").removeAttribute("style");
    document.querySelector("#case").removeChild(h4);
    let removeManager = studentManager;
    printList = init_list();
    const removeName = document.querySelector('#name').value;
    const removeSsn = document.querySelector('#ssn').value;
    let removeStudent = removeManager.removefilter(removeSsn, removeName);
    let test = removeManager.removeStudent(removeSsn, removeName, false);
    console.log(test);
    console.log(removeStudent);
    studentManager.array.length = 0;
    for (let index = 0; index <= removeStudent.length; index++) {
      if (removeStudent.length == 0) {
        document.querySelector("#list").innerHTML = printList
      } else {
        if (index == removeStudent.length) {
          continue;
        } else {
          printList = init_list(removeStudent[index])
          removeManager.searchAll(printList);
          studentManager.array.push(removeStudent[index]);
        }
      }
    }
    document.querySelector("#remove").removeAttribute("disabled");
    studentManager.resigsterAfterInit();
  } else if (event.target && event.target.id == 'reg') {

    btn = document.querySelector("#reg");
    document.querySelector(".Allbtn").removeChild(btn);
    document.querySelector("#case").removeAttribute("style");
    document.querySelector("#case").removeChild(h4);
    //학번 
    ssn = document.querySelector('#ssn').value;
    //이름
    name = document.querySelector('#name').value;
    //국어
    kr = parseInt(document.querySelector('#kr').value);
    //영어
    en = parseInt(document.querySelector('#en').value);
    //수학
    ma = parseInt(document.querySelector('#ma').value);
    studentManager.add(new Student(ssn, name, kr, en, ma))
    let array = studentManager.array;
    printList = init_list();
    list = studentManager.list();
    for (let index = 0; index < list.length; index++) {
      printList = init_list(list[index])
      studentManager.searchAll(printList);
    }
    if (ssn && name && kr && en && ma) studentManager.resigsterAfterInit();

  } else if (event.target && event.target.id == 'delAll') {
    btn = document.querySelector("#delAll")
    document.querySelector(".Allbtn").removeChild(btn);
    document.querySelector("#case").removeAttribute("style");
    document.querySelector("#case").removeChild(h4);
    printList = init_list();
    document.querySelector("#list").innerHTML = printList
    studentManager.array.length = 0;
    document.querySelector("#removeall").removeAttribute("disabled");
  }
})