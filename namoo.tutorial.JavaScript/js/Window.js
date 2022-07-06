console.dir(window);

//window는 생략 가능
console.log(window.constructor);
console.log(constructor);
console.log(window.document);
console.log(document); //window는 생략 가능
console.log(history); //window는 생략 가능
console.log(location); //window는 생략 가능

//window객체가 제공하는 주요 함수....

//window.alert(111);
// alert(111); 같은 의미 보통 window 생략 

/* function show() {
  console.log("tes");
  //this 여기서는 windo를 뜻함
}
show();
 */
//확인
let an=confirm("자바스크립트 쉽나요?")
console.log(an);

//물어보는거
prompt("저녁 뭐먹음?", "백반") //인자가 하나 더 있으면 기본 설정

let mywindow = open('https://www.google.com','pop','width=400','height= 400');
//사용자 이벤트 처리 생략했다고 하고 만약에 없으면 바로 닫힘
mywindow.close();
// close()라고 하면 안됨 현재 브라우저가 닫힘


