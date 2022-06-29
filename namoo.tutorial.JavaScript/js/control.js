let score= 88;

if (score >= 60) {
  console.log("pass"); 
}else{
  console.log("fail");
}

if (score >= 90) {
  console.log("Pass!");
} else if(80 <= score<90){
  console.log("pass");
}else{
  console.log("fail");
}
let result = score >= 60 ? "pass" : "fail";
console.log(result);
let a=parseInt(score/10)
console.log(a);
switch (true) { // switch에 범위 사용시에는 true를 사용
  case (score>= 90): 
      console.log("수");
    break;
  case (80<=score<90):
      console.log("우");
    break;
  default:
      console.log('탈락');
    break;
}
switch (Math.floor(score/10)) { // switch에 범위 사용시에는 true를 사용
  case 10,9: 
      console.log("수");
    break;
  case 8:
      console.log("우");
    break;
  default:
      console.log('탈락');
    break;
}
switch (parseInt(score/10)) { // switch에 범위 사용시에는 true를 사용
  case 10,9: 
      console.log("수");
    break;
  case 8:
      console.log("우");
    break;
  default:
      console.log('탈락');
    break;
}
let index=0;
while (index<100) {
  
  if ((index %2) !==0){
    console.log(index);
  }
  index++;
} 

console.clear();

for (let index=0;index<=100; index++){
  console.log(":"+index);
}
for (let index=0;index<=100; index++){
  if(index%2 ===1) console.log(":"+index);
}
for (let index=0;index<=100; index++){
  if(index%2 !==1) continue;
  console.log(":"+index);
}