//이것을 사용하기 위해서는 script에 type="module"이라고 말해주기
import {Student} from './Student.js';
let student = new Student(100,'jack',80,70,100);
console.log(student);
console.log(student.toString());
//객체안에서의 this는 자기 자신이지만 
//함수안에서는 window를 의미한다. this가 