import { Student } from "./Student.js";
import { StudentManager } from "./StudentManager.js";
import { Careful } from "./Careful.js";

// let studentManager = new StudentManager();
let careful = new Careful();
careful.movefocus();
//prototype에 넣기 StudentMangager에 넣어서
let studentManager = careful.getStudent();
let init_list = studentManager.initList();
let printList;
let list;
let out, kr, ssn, name, en, ma;

const regExp = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\" |a-z|A-Z |ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g;
const regNum = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\" |0-9]/g;
const regLimit = /[^0-9]/g;
const regZero = /^0[0-9]+$/g;

//이름 검색
document.querySelector("#search").addEventListener("click", function (event) {
  printList = init_list();
  const findname = document.querySelector('#name').value;
  let findStudentname = studentManager.idfilter(findname);
  if (findStudentname.length == 0) {
    document.querySelector("#list").innerHTML = printList
  } else {
    for (let index = 0; index < findStudentname.length; index++) {
      printList = init_list(findStudentname[index]);
      studentManager.listAll(printList);
    }
  }

})

//학번 조회
document.querySelector("#smsearch ").addEventListener("click", function (event) {
  printList = init_list();
  const findSsn = document.querySelector('#ssn').value;
  let findStudent = studentManager.filter(findSsn);
  if (findStudent == 0) {
    document.querySelector("#list").innerHTML = printList
  } else {
    for (let index = 0; index < findStudent.length; index++) {
      printList = init_list(findStudent[index]);
      studentManager.listAll(printList);
    }
  }
})

//등록
document.querySelector("#reg").addEventListener("click", function (event) {
  ssn = document.querySelector("#ssn").value;
  name = document.querySelector("#name").value;
  kr = document.querySelector("#kr").value;
  en = document.querySelector("#en").value;
  ma = document.querySelector("#ma").value;

  out = studentManager.array.findIndex(i => i.ssn == ssn);
  document.querySelector("#table").value = out;
  if (ssn == '' || name == '' || kr == '' || en == '' || ma == '') careful.openCenter('registerCheckValueErr.html', "pop", 500, 200);
  else if (out != -1) careful.openCenter('registerCheckValueErr.html', "pop", 500, 200);
  else careful.openCenter('registerCheck.html', "pop", 500, 200);

  let index = careful.empty(ssn, name, kr, en, ma);
  let select = careful.emptyfocus(index);
  careful.movefocus(select);
})

//전체검색
document.querySelector("#allSearch").addEventListener("click", function (event) {
  printList = init_list();
  list = studentManager.list()
  for (let index = 0; index < list.length; index++) {
    printList = init_list(list[index]);
    studentManager.searchAll(printList);
  }
})

//전체 삭제
document.querySelector("#removeall").addEventListener("click", function (event) {
  let empty = studentManager.array.length;
  document.querySelector("#table").value = empty;
  if(empty == 0) careful.openCenter('AlldelCheckErr.html', "pop", 500, 200);
  else careful.openCenter('AlldelCheck.html',"pop",500,200);
})

//이름 and 삭제 
document.querySelector("#remove").addEventListener("click", function (event) {
  ssn = document.querySelector("#ssn").value;
  name = document.querySelector("#name").value;
  out = studentManager.array.findIndex(i => i.ssn == ssn && i.name == name);
  document.querySelector("#table").value = out;

  if (ssn == '' || name == '') careful.openCenter('delCheckValueErr.html', "pop", 500, 200);
  else if (out == -1) careful.openCenter('delCheckValueErr.html', "pop", 500, 200);
  else careful.openCenter('delCheck.html', "pop", 500, 200);
  let index = careful.empty(ssn, name);
  if (index <= 2) {
    let select = careful.emptyfocus(index);
    careful.movefocus(select);
  }
})

document.querySelector("#sort").addEventListener("click", function (event) {
  out = studentManager.array.findIndex(i => i.ssn == ssn && i.name == name);
  document.querySelector("#table").value = out;
  if(out ==  -1 ) careful.openCenter('SortCheckerr.html', "pop", 500, 200);
  else careful.openCenter('SortCheck.html', "pop", 500, 200);
})

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
  if(kr >= 100) document.querySelector("#kr").value = 100;
})
document.querySelector("#en").addEventListener("input", function (event) {
  en = document.querySelector("#en").value;
  if (regLimit.test(en)) {
    document.querySelector("#en").value = en.replace(regLimit, '');
  }
  if (regZero.test(en)) {
    document.querySelector("#en").value = en.replace(regZero, '0');
  }
  if(en >= 100) document.querySelector("#en").value = 100;
})
document.querySelector("#ma").addEventListener("input", function (event) {
  ma = document.querySelector("#ma").value;
  if (regLimit.test(ma)) {
    document.querySelector("#ma").value = ma.replace(regLimit, '');
  }
  if (regZero.test(ma)) {
    document.querySelector("#ma").value = ma.replace(regZero, '0');
  }
  if(ma >= 100) document.querySelector("#ma").value = 100;
})