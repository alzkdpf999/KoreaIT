import {Student} from "./Student.js";
import {StudentManager} from "./StudentManager.js";
/* let studentManager = new StudentManager();
let student = new Student(1,'jack',90,100,50);
studentManager.add(student);
studentManager.add(new Student(2,'gic',90,100,50));
studentManager.add(new Student(3,'jyo',60,90,20));
studentManager.add(new Student(4,'alma',60,70,40));
studentManager.add(new Student(5,'folf',40,80,40));

const list =studentManager.list();

list.forEach(student => {
  console.log(student.toString())
});*/

//학번 조회

document.querySelector("#smsearch").addEventListener("click",function(event){
  const a=document.querySelector('#ssn').value;
  console.log(a);
  })

  // const findStudent = new StudentManager().find()
document.querySelector("#register").addEventListener("click",function(event){
  let studentManager = new StudentManager();
  studentManager.add(new Student(2,'ghos',90,100,50))
  const list =studentManager.list();
  // listAll(list);
  test(list);
})
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
function test(list) {
  let ul= document.createElement("ul");
  for (const index of list) {
    for (const key in index) {
      let li= document.createElement("li");
      if(typeof(index[key]) === 'function' || key == 'schoolName'){
        continue;
      }
      let txt = document.createTextNode(index[key]);
      li.setAttribute('margin', '5');
      
      li.appendChild(txt);
      ul.appendChild(li);
    }
    let txt = document.createTextNode(`${index.getAverage()}`);
    let li = document.createElement("li")
    li.setAttribute('margin','5');
    li.appendChild(txt);
    
    ul.appendChild(li);
    
  }
  document.querySelector("#list").appendChild(ul);
  
}