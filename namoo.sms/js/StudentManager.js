import { Student } from "./Student.js"

// Array를 이용하여 다수의 학생 관리
function StudentManager() {
  //this = {};
  this.array = [];
  //return this;
}

StudentManager.prototype.initList = function () {
  let printList = '';
  return function init_list() {
    if (arguments.length == 0) {
      printList = `<ul>
  <li>학번</li><li>이름</li><li>국어</li><li>영어</li><li>수학</li><li>평균</li>
</ul>`;
      return printList;
    } else {
      for (let i = 0; i < arguments.length; i++) {
        printList += `<ul>`
        printList += `<li>${arguments[i].ssn}</li><li>${arguments[i].name}</li><li>${arguments[i].korean}</li><li>${arguments[i].english}</li><li>${arguments[i].math}</li><li>${arguments[i].getAverage()}</li>`;
        printList += `</ul>`;
      }
      return printList;

    }
  }
}

//학생 등록 
StudentManager.prototype.add = function (student) {
  if (student == undefined) {
    console.log("학생을 입력해주세요");
  } else {
    this.array.push(student);
  }
}

//학생 전체목록 조회
StudentManager.prototype.list = function () {
  return this.array.slice(0, this.array.length);// 처음부터 끝까지 
  // return this.array.slice();// 처음부터 끝까지  같은 코딩
}

StudentManager.prototype.filter = function (ssn) {
  return this.array.filter(function (student) {
    return student.ssn == ssn;
  })
}

StudentManager.prototype.idfilter = function (name) {
  return this.array.filter(function (student) {
    return student.name == name;
  })
}

//삭제 true면 삭제하고 남은 학생들 false면 삭제한 학생
StudentManager.prototype.removefilter = function (ssn, name, bool = true) {
  return this.array.filter(function (student) {
    if (bool === true) {
      let result = (student.name !== name || student.ssn !== ssn);

      return result;
    } else {
      let result = (student.name === name && student.ssn === ssn);

      return result;
    }
  })
}
//삭제한 학생 확인
StudentManager.prototype.removeStudent = function (ssn, name) {
  return this.array.filter(function (student) {

    let result = (student.name === name && student.ssn === ssn);

    return result;
  })
}

StudentManager.prototype.listAll = function (printList) {

  document.querySelector("#list").innerHTML = printList
}
//전체 검색./
StudentManager.prototype.searchAll = function (printList) {

  document.querySelector("#list").innerHTML = printList
}

StudentManager.prototype.sorting = function (identy) {
  switch (identy) {
    case "ssn":
      this.array.sort(function (x, y) {
        return x.ssn - y.ssn;
      })
      break;
    case "name":
      this.array.sort(function (x, y) {
        if (x.name.charCodeAt(0) == y.name.charCodeAt(0))
          return x.ssn - y.ssn;
        else return x.name.charCodeAt(0) - y.name.charCodeAt(0);

      })
      break;
    case "kr":
      this.array.sort(function (x, y) {

        if (x.korean == y.korean)
          return x.ssn - y.ssn;
        else return x.korean - y.korean;
      })
      break;
    case "en":
      this.array.sort(function (x, y) {
        if (x.english == y.english)
          return x.ssn - y.ssn;
        else return x.english - y.english;
      })
      break;
    case "math":
      this.array.sort(function (x, y) {
        if (x.math == y.math)
          return x.ssn - y.ssn;
        else return x.math - y.math;
      })
      break;
    default:
      this.array.sort(function (x, y) {
        if (x.getAverage() == y.getAverage())
          return x.ssn - y.ssn;
        else return x.getAverage() - y.getAverage();
      })
  }
}

export { StudentManager };

