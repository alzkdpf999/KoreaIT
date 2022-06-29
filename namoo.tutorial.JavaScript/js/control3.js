let array = [1,2,3,4,5,6,7,8,9,10]; //배열 
for (let i=0;i<array.length;i++){
  console.log(array[i]);
}

for( let i in array){
  console.log(array[i]); //순서를 i에다가 넣어준다.
}
for (const value of array) { //자바처럼 값을 가지고옴 
  console.log(value);
}