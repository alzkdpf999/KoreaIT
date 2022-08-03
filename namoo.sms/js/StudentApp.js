import {Student} from "./Student.js";
import {StudentManager} from "./StudentManager.js";
import {Careful} from "./Careful.js";

let studentManager = new StudentManager();
let careful = new Careful();
careful.movefocus();
//prototype에 넣기 StudentMangager에 넣어서

let init_list=studentManager.initList();
<<<<<<< HEAD

=======



>>>>>>> c3b143f298a95df0e2e933d0b7c66113d4a2ad75
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
    printList=init_list(findStudentname[index]);
    searchAllManager.listAll(printList);
  }
}

  })

//학번 조회
document.querySelector("#smsearch ").addEventListener("click",function(event){
  let printList=init_list();
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
<<<<<<< HEAD
  let array=studentManager.array;
=======
>>>>>>> c3b143f298a95df0e2e933d0b7c66113d4a2ad75
  let printList=init_list();
  let list = studentManager.list();
  for(let index = 0; index<list.length;index++)
  {
<<<<<<< HEAD
    searchAll(list[index]);
=======
    printList=init_list(list[index])
    studentManager.searchAll(printList);
>>>>>>> c3b143f298a95df0e2e933d0b7c66113d4a2ad75
  }
  let index = careful.empty(ssn,name,kr,en,ma);  
  let select = careful.emptyfocus(index);
  if(ssn && name && kr && en && ma) careful.resigsterAfterInit();
  careful.movefocus(select);
})

//전체검색
document.querySelector("#allSearch").addEventListener("click",function(event){
  let printList=init_list();
  let list =studentManager.list()
  for(let index =0; index<list.length;index++)
  { 
    printList=init_list(list[index]);
    studentManager.searchAll(printList);
  }
})

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
  let test= removeManager.removeStudent(removeSsn,removeName,false);
  console.log(test);
  console.log(removeStudent);
  studentManager.array.length = 0;
  for(let index =0; index<=removeStudent.length;index++)
  {
    if(removeStudent.length == 0){
      document.querySelector("#list").innerHTML = printList
    }else{
      if(index ==removeStudent.length)
      {
        continue;
      }else{
        printList=init_list(removeStudent[index])
        removeManager.searchAll(printList);
      studentManager.array.push(removeStudent[index]);
      }
  } 
  }
})

document.querySelector("#sort").addEventListener("click",function(event){
  careful.openCenter('SortCheck.html',"pop",500,200);
  console.log(document.querySelector("#sort").value);
})