import {Student} from "./Student.js";
import {StudentManager} from "./StudentManager.js";
let studentManager = new StudentManager();
//학번 조회

document.querySelector("#smsearch").addEventListener("click",function(event){
  const findSsn = document.querySelector('#ssn').value;
  //console.log(studentManager.array[1]);//2개라 했을때 표의 위치상 첫번쨰거가 나옴
  const findStudent=studentManager.find(findSsn);
  console.log(findStudent); //일단 마지막에 나온 것만 출력 아마 for문으로 하는게 좋을지 
  // console.log(findStudent);
    // if(findStudent){
    //   console.log(findStudent);
    // }else{
    //   console.log("번호를 잘못 입력하였습니다.");
    // }
  
  })
document.querySelector("#register").addEventListener("click",function(event){
  //학번 
  const ssn=document.querySelector('#ssn').value;
  //이름
  const name=document.querySelector('#id').value;
  //국어
  const kr= parseInt(document.querySelector('#kr').value);
  //영어
  const en=parseInt(document.querySelector('#en').value);
  //수학
  const ma=parseInt(document.querySelector('#ma').value);
  studentManager.add(new Student(ssn,name,kr,en,ma))
  resigsterList(studentManager.array.reverse().slice(0,1));
})
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

/* 
let printList = `<ul>
<li>학번</li>
<li>이름</li>
<li>국어</li>
<li>영어</li>
<li>수학</li>
<li>평균</li>
</ul>`;
function listAll(list){
  printList+=`<ul>`
  console.log(list);
  for (const index of list) {
    console.log(index);
    printList+= `<li>${index.ssn}</li><li>${index.name}</li><li>${index.korean}</li><li>${index.english}</li><li>${index.math}</li><li>${index.getAverage()}</li>`;
    printList+=`</ul>`;
  }
  document.querySelector("#list").innerHTML = printList
}
 */