let left = (screen.availWidth - width) / 2;
let top = (screen.availHeight - height) / 2;
let option = "letf=" + left + ",top=" + top + ",width=" + width + ",height=" + height;

document.querySelector("#dbCheckId").addEventListener("click",function(event){
	window.open("https://www.naver.com/","pop",option); 
})