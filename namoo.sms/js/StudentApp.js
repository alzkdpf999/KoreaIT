import {Student} from "./Student.js";
import {StudentManager} from "./StudentManager.js";
import {Careful} from "./Careful.js";

let studentManager = new StudentManager();
let init_list=initList();
let cnt=increamentCount()
let careful = new Careful();
careful.movefocus();
//prototype에 넣기 StudentMangager에 넣어서


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
//이름 검색
document.querySelector("#search").addEventListener("click",function(event){
  let printList=init_list();
  let searchAllManager = studentManager;
  const findname = document.querySelector('#name').value;
  let findStudentname = searchAllManager.idfilter(findname);
  if(findStudentname.length == 0){
    document.querySelector("#list").innerHTML = printList
  }else{
  for(let index = 0; index<findStudentname.length;index++)
  {
    listAll(findStudentname[index]);
  }
}

  console.log(cnt());     
  })

//학번 조회
document.querySelector("#smsearch ").addEventListener("click",function(event){
  let printList=init_list();
  console.log(printList);
  let searchStudentManager = studentManager;
  // console.log(searchStudentManager.list());x
  const findSsn = document.querySelector('#ssn').value;
  //console.log(studentManager.array[1]);//2개라 했을때 표의 위치상 첫번쨰거가 나옴
  let findStudent=searchStudentManager.filter(findSsn);
  console.log(findStudent);
  if(findStudent == 0){
    document.querySelector("#list").innerHTML = printList
  }else{
  for(let index =0; index<findStudent.length;index++)
  {
    listAll(findStudent[index]);
  }
}

  console.log(cnt()); 
  })

//등록
document.querySelector("#register").addEventListener("click",function(event){
  //학번 
  const ssn=document.querySelector('#ssn').value;
  //이름
  const name=document.querySelector('#name').value;
  //국어
  const kr= parseInt(document.querySelector('#kr').value);
  //영어
  const en=parseInt(document.querySelector('#en').value);
  //수학
  const ma=parseInt(document.querySelector('#ma').value);
  studentManager.add(new Student(ssn,name,kr,en,ma))
  let array=studentManager.array;
  if(cnt() != 0){
    let printList=init_list();
    console.log(printList);
    let list = studentManager.list();
    for(let index = 0; index<list.length;index++)
  {
    searchAll(list[index]);
  }
  cnt(1);
  }else{
    resigsterList(array.slice(array.length-1,array.length));
  } 

  // careful.movefocus("name");
  careful.movefocus();
  careful.resigsterAfterInit();
})
//등록 함수
function resigsterList(list) {
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
//전체검색
document.querySelector("#allSearch").addEventListener("click",function(event){
  let printList=init_list();
  let list =studentManager.list()
  for(let index =0; index<list.length;index++)
  {
    searchAll(list[index]);
  }
})
//전체 검색./
function searchAll(index){
  let printList=init_list(index);
  document.querySelector("#list").innerHTML = printList
}
//전체 삭제
document.querySelector("#removeall").addEventListener("click",function(event){
  let printList=init_list();
  document.querySelector("#list").innerHTML = printList
  studentManager.array.length=0;
})
//이름 and 삭제 
document.querySelector("#remove").addEventListener("click",function(event){
  let removeManager = studentManager;
  let printList = init_list();
  const removeName = document.querySelector('#name').value;
  const removeSsn = document.querySelector('#ssn').value;
  let removeStudent = removeManager.removefilter(removeSsn,removeName);
  // let removeList =removeStudent.list()
  console.log(removeStudent);
  studentManager.array.length = 0;
  for(let index =0; index<removeStudent.length;index++)
  {
    console.log(index+"번째"+removeStudent[index]);
    studentManager.array.push(removeStudent[index]);
  }
  AllSearch(removeStudent);

})
function AllSearch(temp){
  let printList = init_list();let a=0;
  for(let i=0;i<temp.length;i++){
  printList = init_list(temp[i]);
  }
  document.querySelector("#list").innerHTML = printList;
}