import { Validitycheck as valid } from "/js/Validitycheck.js";

let val = document.querySelector("#id");

document.querySelector("#id").addEventListener("input",function(event){
	console.log(valid.Id(val.value))
	console.log(val.value)
	if(!valid.Id(val.value)){
		document.querySelector(".check").setAttribute("disabled","disabled")
		val.setAttribute("style", "color: red");
		if(valid.Id(val.value)){
			document.querySelector(".check").removeAttribute("disabled")
			val.setAttribute("style", "color: green");
		}
	}
})

document.querySelector("#CheckId").addEventListener("click",function(event){
	opener.document.querySelector("#id").value=document.querySelector("#id").value;
	opener.document.querySelector("#dbCheckId").setAttribute("disabled","disabled");
	self.close();
})
document.querySelector("#cancle").addEventListener("click",function(event){
	self.close();
	
})
