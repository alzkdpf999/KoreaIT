//함수 스코프 let이라고 하면 자바처럼 행동 var라고 하면 그 함수안에 변수가 다 접근 가능
/* var global = '전역'
function doSomeThing(){
  var local = '지역'
  console.log(global);
  console.log(local);
  for (var i  = 0; i < 10; i++) {
    
  }
  console.log(i); //함수안에 선언된 지역변수에 다 접근 가능 
}  
  doSomeThing(); */
//  console.log(local); error
let global = '전역'
function doSomeThing(){
  let local = '지역'
  console.log(global);
  console.log(local);
  for (let i  = 0; i < 10; i++) {
  }
  //console.log(i); //let 이므로 접근 불가 err 
}  
  doSomeThing();

//덮어버릴수 있음  나중에

//some(); 이것도 가능 이것이 hoisiting
  function some() {
    console.log("aaaaaaaa");
  }

  function some() {
    console.log('bbbbbbb');
  }
  some();
  //------------------------------

  //빗변의 길이 반환
  function hypotenus(x,y) {
    function jegob(val,n) { //hypotenus에서만 쓰기떄문에  그 안에서만 쓰면 중첩으로 쓰면 좋다
      return Math.pow(val,n);
    }
    a=jegob(x,2)+ jegob(y,2);
    
    console.log(Math.sqrt(a));
  }
  //제곱을 반롼하는 함수

  hypotenus(6,8);

  
