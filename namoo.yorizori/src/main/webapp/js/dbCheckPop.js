import { Validitycheck as valid } from "./Validitycheck.js";


document.querySelector("#id").addEventListener("input",function(event){

 const val = document.querySelector(".idCheck").value;
 console.log(val);
 if(!valid.Id(val)){
	document.querySelector("#dbCheckId").setAttribute("disabled","disabled");
}
if(valid.Id(val)){
 document.querySelector("#CheckId").setAttribute("disabled","disabled");
 document.querySelector("#dbCheckId").removeAttribute("disabled");
	}
 
})

document.querySelector("#CheckId").addEventListener("click",function(event){
	opener.document.querySelector(".signupId").value = document.querySelector("#id").value;
	opener.document.querySelector("#dbCheckId").setAttribute("disabled","disabled");
	opener.document.querySelector("#signOk").removeAttribute("disabled");
	opener.document.querySelector("#ok").value = "check"
	self.close();
})
document.querySelector("#cancle").addEventListener("click",function(event){
	self.close();
	
})
