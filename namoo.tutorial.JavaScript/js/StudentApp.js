import {Student} from "./Student.js";
import {StudentManager} from "./StudentManager.js";


let studentManager = new StudentManager();
let student = new Student(1,'jack',90,100,50);
studentManager.add(student);
studentManager.add(new Student(2,'gic',90,100,50));
studentManager.add(new Student(3,'jyo',60,90,20));
studentManager.add(new Student(4,'alma',60,70,40));
studentManager.add(new Student(5,'folf',40,80,40));

const list =studentManager.list();

list.forEach(student => {
  console.log(student.toString())
});

//학번 조회
const findStudent=studentManager.find(3);
if(findStudent){
  console.log(findStudent);
}else{
  console.log("번호를 잘못 입력하였습니다.");
}