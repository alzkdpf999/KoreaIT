//let array = new Array();
let array = [10,20,30,40, , null, undefined, 'rooney',true,{name:'jack'},new Date()];

console.dir(array);
for(let i =0 ; i<array.length;i++){
  const element = array[i];
  if (!element){ //undefined 출력안하게
    continue;
  }
  console.log(element);
}
console.log("for in");

for (const asd in array) {
  console.log(`${array[asd]}`);
}
console.log("for of");
for (const iterator of array) {
  console.log(iterator);
}
console.log("for each");
array.forEach(function(value,index){
  if((typeof value) === Object){
    console.log(value.name);
  }else{
    console.log(value);
  }
});
// console.clear();

// Array.prototype의 주요메소드
let arr = [1,2];
//맨 뒤에 추가
arr.push(3);
arr.push(4,5);
console.dir(arr); //5까지 다나옴 순서대로
//맨 뒤에 삭제하고 지운거 반환
console.log(arr.pop());
console.log(arr.length);
//맨 앞에 추가
arr.unshift(0);
arr.unshift(11,12);
console.dir(arr);
//맨 앞에 지우고 지운거 반환
console.log(arr.shift());
console.dir(arr);
//arr.join()처럼 인자가 없으면 ,로 해줌 
console.log(arr.join('-'));

//split join에 반대되는
let message = "java, html, css, javascript, sql";
let arr2 = message.split(','); //정규표현식 지원함
console.dir(arr2);
let arr4 = arr2.concat("git","sqld","Servlet","JSP");
console.dir(arr4);
//이거는 3의 앞인 2까지만
console.log(arr4.slice(1,3));

//이거는 3까지 삭젝하고 반환
console.log(arr4.splice(1,3));
console.dir(arr4);
//splice 추가할때는 첫번째인자는 처음을 알리고 두번째인자는 삭제 갯수 세번째는 삽입할 원소
arr4.splice(0,0,'python','react','jquery');
console.dir(arr4);
// arr5.splice(2,2,'c','d');
// console.dir(ar45);


let nums = [3,1,7,8,2,10];
//console.log(nums.sort()) ;//1,10,2,3,7,8 이렇게 정렬된 유니코드 값에 따라서
//이기에 이상하게 나옴

//callback
nums.sort((x,y) => x-y);
/* nums.sort(function(x,y){
  return x-y;
}) */
console.dir(nums)
