//비동기 프로그래밍
console.log("1출력");
console.log("2출력");
console.log("3출력");
console.log("4출력");
function print() {
  console.log("5출력");
}

setTimeout(function(){
  console.log("0출력");
},2000);


console.log("6출력");



setTimeout(print,1000);

window.addEventListener("load",function () {
  this.setInterval(function(){
    // console.log("ddd");
    let time= new Date();
    let timeString = time.toLocaleTimeString();
    document.querySelector("#clock").innerHTML = timeString;
  },1000);
})