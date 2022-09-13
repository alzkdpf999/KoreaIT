document.querySelector("#recipe_sequence").addEventListener("click", function(event) {
	if (event.target && event.target.id == "add") {
		if (document.querySelectorAll(".seq_num").length >= 6) {
			document.querySelector("#add").setAttribute("disabled", "disabled");
		} else {
			let input = document.createElement("input");
			input.className = "form-control";
			input.setAttribute("type", "text");
			input.setAttribute("name", "seq_num");
			input.setAttribute("id", "seq_num");
			input.classList.add("seq_num");
			document.querySelector("#sequence").appendChild(input);
		}
		if (document.querySelector("#del").getAttribute("disabled")) {
			document.querySelector("#del").removeAttribute("disabled");
		}
	} else if (event.target && event.target.id == "del") {
		if (document.querySelector("#add").getAttribute("disabled")) {
			document.querySelector("#add").removeAttribute("disabled");
		}
		if (document.querySelectorAll(".seq_num").length <= 3) {
			document.querySelector("#del").setAttribute("disabled", "disabled");
		} else {
			document.querySelector("#sequence").removeChild(document.querySelector("input.seq_num:last-child"));
		}

	}
})
document.querySelector("#imgdelbtn").addEventListener("click",function(event){
	document.querySelector("#imgdel").value = "ok";
		document.querySelector("#imgdelbtn").classList.replace("btn-outline-danger", "btn-danger");
})
document.querySelector("#img_file_name").addEventListener("click",function(event){
	document.querySelector("#imgdel").value = "no";
		document.querySelector("#imgdelbtn").classList.replace("btn-danger", "btn-outline-danger");
})