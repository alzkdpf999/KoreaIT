import {Student} from "./Student.js";
import {StudentManager} from "./StudentManager.js";

let studentManager = new StudentManager();
let count=0;
let printList='';

//이름 검색
document.querySelector("#search").addEventListener("click",function(event){
  printList=`<ul>
  <li>학번</li>
  <li>이름</li>
  <li>국어</li>
  <li>영어</li>
  <li>수학</li>
  <li>평균</li>
</ul>`;
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
  ++count;
  // console.log(count);     
  })

//학번 조회
document.querySelector("#smsearch ").addEventListener("click",function(event){
  printList=`<ul>
  <li>학번</li>
  <li>이름</li>
  <li>국어</li>
  <li>영어</li>
  <li>수학</li>
  <li>평균</li>
</ul>`;
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
  ++count;
  console.log(count);
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
  if(count != 0){
    printList = `<ul>
  <li>학번</li>
  <li>이름</li>
  <li>국어</li>
  <li>영어</li>
  <li>수학</li>
  <li>평균</li>
  </ul>`;
    let list = studentManager.list();
    for(let index = 0; index<list.length;index++)
  {
    searchAll(list[index]);
  }
  
    count = 0;
  }else{
    resigsterList(array.slice(array.length-1,array.length));
  } 
  
  
})
//등록 함수
function resigsterList(list) {
  let ul= document.createElement("ul");
  for (const index of list) {
    for (const key in index) {
      let li= document.createElement("li");
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
  printList += `<ul>`
  printList += `<li>${list.ssn}</li><li>${list.name}</li><li>${list.korean}</li><li>${list.english}</li><li>${list.math}</li><li>${list.getAverage()}</li>`;
  printList += `</ul>`;
  document.querySelector("#list").innerHTML = printList
}
//전체검색
document.querySelector("#allSearch").addEventListener("click",function(event){
  printList = `<ul>
  <li>학번</li>
  <li>이름</li>
  <li>국어</li>
  <li>영어</li>
  <li>수학</li>
  <li>평균</li>
  </ul>`;
  let list =studentManager.list()
  for(let index =0; index<list.length;index++)
  {
    searchAll(list[index]);
  }
})
//전체 검색./
function searchAll(index){
  printList+=`<ul>`
  printList+= `<li>${index.ssn}</li><li>${index.name}</li><li>${index.korean}</li><li>${index.english}</li><li>${index.math}</li><li>${index.getAverage()}</li>`;
  printList+=`</ul>`;
  document.querySelector("#list").innerHTML = printList
}
//전체 삭제
document.querySelector("#removeall").addEventListener("click",function(event){
  printList = `<ul>
  <li>학번</li>
  <li>이름</li>
  <li>국어</li>
  <li>영어</li>
  <li>수학</li>
  <li>평균</li>
  </ul>`;
  document.querySelector("#list").innerHTML = printList
  studentManager.array.length=0;
})
//이름 and 삭제 
document.querySelector("#remove").addEventListener("click",function(event){
  let removeManager = studentManager;
  printList = `<ul>
  <li>학번</li>
  <li>이름</li>
  <li>국어</li>
  <li>영어</li>
  <li>수학</li>
  <li>평균</li>
  </ul>`;
  const removeName = document.querySelector('#name').value;
  const removeSsn = document.querySelector('#ssn').value;
  let removeStudent = removeManager.removefilter(removeSsn,removeName);
  // let removeList =removeStudent.list()
  console.log(removeStudent);
  studentManager.array.length = 0;
  for(let index =0; index<=removeStudent.length;index++)
  {
    if(index == removeStudent.length){
      console.log(removeStudent.length);
      document.querySelector("#list").innerHTML = printList
    }else{
      searchAll(removeStudent[index]);
      studentManager.array.push(removeStudent[index]);
  } 
}
})