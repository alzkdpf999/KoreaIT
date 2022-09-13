document.querySelector("a#listDel").addEventListener("click",function(event) {
	document.querySelector("div#alert").setAttribute("style","display:flex");
})


document.querySelector("a.del").addEventListener("click",function(event) {
	document.querySelector("div#alert").removeAttribute("style");
})


document.querySelector("button.cancle").addEventListener("click",function(event) {
	document.querySelector("div#alert").removeAttribute("style");
})