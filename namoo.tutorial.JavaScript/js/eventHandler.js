let target = document.querySelector("#button");
target.addEventListener("click", (event) => {
  console.log('이벤트 처리');
  console.dir(event)
  event.target.style.backgroundColor = "red"; // 이렇게 처리도 가능 
});
target.addEventListener("mouseenter", (event) => {
  event.target.style.backgroundColor = "yellow"; // 이렇게 처리도 가능 
});
target.addEventListener("mouseleave", (event) => {
  event.target.style.backgroundColor = "blue"; // 이렇게 처리도 가능 
});

document.querySelector("#tf").addEventListener("keypress", (event) =>{
  console.log(event.key);
});

document.querySelector("#tf").addEventListener("focus",(event) =>{
  event.target.style.backgroundColor = "black";
  event.target.style.color  = "white"
});
document.querySelector("#tf").addEventListener("blur",(event) =>{
  alert("hi");
});


document.querySelector("#tf2").addEventListener("change",function(event){
  console.log(event.target.value);
  console.log(this.value);
  this.value="";
  this.focus();
});
document.querySelector("#pet-select").addEventListener("change",function(event){
  console.dir(event);
  console.log(this.value);
  alert(this);
  //const select = this; //event.target == this
  let value = this.options[this.selectedIndex].value;
  // const value = select.options[select.selectedIndex].value;
  // const text = select.options[select.selectedIndex].text;
  let text = this.options[this.selectedIndex].text;
  console.log(text + '(' + value + ')선택');
});