let target = document.querySelector("#button");
target.addEventListener("click", (event) => {
  console.log('이벤트 처리');
  console.dir(event)
  event.target.style.backgroundColor = "red"; // 이렇게 처리도 가능 
}, false);
target.addEventListener("mouseenter", (event) => {
  event.target.style.backgroundColor = "yellow"; // 이렇게 처리도 가능 
}, false);
target.addEventListener("mouseleave", (event) => {
  event.target.style.backgroundColor = "blue"; // 이렇게 처리도 가능 
}, false);

document.querySelector("#tf").addEventListener("keypress", (event) =>{
  console.log(event.key);
})