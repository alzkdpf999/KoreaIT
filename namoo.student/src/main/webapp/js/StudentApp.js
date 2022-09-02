import {Student} from "./Student.js";
import {StudentManager} from "./StudentManager.js";
import {Careful} from "./Careful.js"
function StudentApp(){

}
let studentManager = new StudentManager();

let careful = new Careful();
careful.movefocus();
let printList;
let out, kr, ssn, name, en, ma;
let list;
const regExp = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\" |a-z|A-Z |ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g;
const regNum = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\" |0-9]/g;
const regLimit = /[^0-9]/g;
const regZero = /^0[0-9]+$/g;

let init_list=studentManager.initList();
//이름 검색
document.querySelector("#search").addEventListener("click",function(event){
  printList=init_list();
  let searchAllManager = studentManager;
  const findname = document.querySelector('#name').value;
  let findStudentname = searchAllManager.idfilter(findname);
  if(findStudentname.length == 0){
    document.querySelector("#list").innerHTML = printList
  }else{
  for(let index = 0; index<findStudentname.length;index++)
  {
    printList=init_list(findStudentname[index]);
    searchAllManager.listAll(printList);
  }
}

  })

//학번 조회
document.querySelector("#smsearch ").addEventListener("click",function(event){
  printList=init_list();
  let searchStudentManager = studentManager;
  const findSsn = document.querySelector('#ssn').value;
  let findStudent=searchStudentManager.filter(findSsn);
  if(findStudent == 0){
    document.querySelector("#list").innerHTML = printList
  }else{
  for(let index =0; index<findStudent.length;index++)
  { printList=init_list(findStudent[index]);
    searchStudentManager.listAll(printList);
  }
}
  })
  
//등록
document.querySelector("#register").addEventListener("click",function(event){
  //학번 
  ssn=document.querySelector('#ssn').value;
  //이름
  name=document.querySelector('#name').value;
  //국어
  kr= parseInt(document.querySelector('#kr').value);
  //영어
  en=parseInt(document.querySelector('#en').value);
  //수학
  ma=parseInt(document.querySelector('#ma').value);
  studentManager.add(new Student(ssn,name,kr,en,ma))
  let array=studentManager.array;
  printList=init_list();
  list = studentManager.list();
  for(let index = 0; index<list.length;index++)
  {
    printList=init_list(list[index])
    studentManager.searchAll(printList);
  }
  let index = careful.empty(ssn,name,kr,en,ma);  
  let select = careful.emptyfocus(index);
  if(ssn && name && kr && en && ma) careful.resigsterAfterInit();
  careful.movefocus(select);
})

//전체검색
document.querySelector("#allSearch").addEventListener("click",function(event){
  printList=init_list();
  let list =studentManager.list()
  for(let index =0; index<list.length;index++)
  { 
    printList=init_list(list[index]);
    studentManager.searchAll(printList);
  }
})

//전체 삭제
document.querySelector("#removeall").addEventListener("click",function(event){
  printList=init_list();
  document.querySelector("#list").innerHTML = printList
  studentManager.array.length=0;
})

//삭제 팝업
document.querySelector("#remove").addEventListener("click",function(event){
    //학번 
    ssn=document.querySelector('#ssn').value;
    //이름
    name=document.querySelector('#name').value;
  document.querySelector("#case").setAttribute("style", "display: flex;");
  let btn1 = document.createElement('button');
  let h4 =document.createElement('h4');
  let txt = document.createTextNode(`(${ssn}) ${name}삭제하시겠습니까?`);
  let txt1 = document.createTextNode(`삭제`);
  btn1.className='btn btn-dark del';
  h4.className='h4'
  btn1.setAttribute("type" ,"button");
  btn1.setAttribute("onclick","StudentApp.prototype.del();")
  h4.appendChild(txt);
  document.querySelector("#case").appendChild(h4);
  btn1.appendChild(txt1);
  document.querySelector(".Allbtn").prepend(btn1);
  
})

document.querySelector(".cancle").addEventListener("click",function(event){
  document.querySelector("#case").removeAttribute("style");
  if(document.querySelector(".del")){
    let h4 = document.querySelector(".h4");
    document.querySelector("#case").removeChild(h4);
    let btn = document.querySelector(".del");
    document.querySelector(".Allbtn").removeChild(btn);
  }
})

StudentApp.prototype.del = function(){
  let removeManager = studentManager;
  printList = init_list();
  const removeName = document.querySelector('#name').value;
  const removeSsn = document.querySelector('#ssn').value;
  let removeStudent = removeManager.removefilter(removeSsn,removeName);
  let test= removeManager.removeStudent(removeSsn,removeName,false);
  console.log(test);
  console.log(removeStudent);
  studentManager.array.length = 0;
  for(let index =0; index<=removeStudent.length;index++)
  {
    if(removeStudent.length == 0){
      document.querySelector("#list").innerHTML = printList
    }else{
      if(index == removeStudent.length)
      {
        continue;
      }else{
        printList=init_list(removeStudent[index])
        removeManager.searchAll(printList);
      studentManager.array.push(removeStudent[index]);
      }
  } 
  }
  document.querySelector("#case").removeAttribute("style");
}
//이름 and 학번 일치하면  삭제 
/* document.querySelector(".del").addEventListener("click",function(event){
  let removeManager = studentManager;
  printList = init_list();
  const removeName = document.querySelector('#name').value;
  const removeSsn = document.querySelector('#ssn').value;
  let removeStudent = removeManager.removefilter(removeSsn,removeName);
  let test= removeManager.removeStudent(removeSsn,removeName,false);
  console.log(test);
  console.log(removeStudent);
  studentManager.array.length = 0;
  for(let index =0; index<=removeStudent.length;index++)
  {
    if(removeStudent.length == 0){
      document.querySelector("#list").innerHTML = printList
    }else{
      if(index == removeStudent.length)
      {
        continue;
      }else{
        printList=init_list(removeStudent[index])
        removeManager.searchAll(printList);
      studentManager.array.push(removeStudent[index]);
      }
  } 
  }
  document.querySelector("#case").removeAttribute("style");
})*/

document.querySelector("#sort").addEventListener("click",function(event){
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