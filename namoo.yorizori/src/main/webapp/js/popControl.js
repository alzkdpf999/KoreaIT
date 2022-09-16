document.querySelector("body").addEventListener("click", function(event) {
	if (event.target && event.target.id == "bookdel") {
		document.querySelector("div#alert").setAttribute("style", "display:flex");
	}
})


document.querySelector("a.del").addEventListener("click", function(event) {
	document.querySelector("div#alert").removeAttribute("style");
})


document.querySelector("a.cancle").addEventListener("click", function(event) {
	document.querySelector("div#alert").removeAttribute("style");
})