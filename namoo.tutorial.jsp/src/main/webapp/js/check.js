import { Validitycheck as valid } from "/js/Validitycheck.js";

let option = "width=400,height=250,left=700,top=400,scrollbars=no";
let id = document.querySelector("#id");
let passwd = document.querySelector("#passwd");
let name = document.querySelector("#name");
let email = document.querySelector("#email");
document.querySelector("#id").addEventListener("input",function(event){
	
	if(!valid.Id(id.value)){
		document.querySelector(".check").setAttribute("disabled","disabled")
		id.setAttribute("style", "color: red");
		if(valid.Id(id.value)){
			document.querySelector(".check").removeAttribute("disabled")
			id.setAttribute("style", "color: green");
		}
	}
})
document.querySelector("#passwd").addEventListener("input",function(event){
	console.log(passwd.value);
	console.log(valid.Passwd(passwd.value));
	if(!valid.Passwd(passwd.value)){
		passwd.setAttribute("style", "color: red");
	}
		if(valid.Passwd(passwd.value)){
			passwd.setAttribute("style", "color: green");
		}	
})


document.querySelector("#name").addEventListener("input",function(event){
	console.log(name.value);
	console.log(valid.NameKr(passwd.value));
	console.log(valid.NameEn(passwd.value));
	if(!valid.NameKr(name.value) || !valid.NameEn(name.value)){
		name.setAttribute("style", "color: red");
	}
		if(valid.NameKr(name.value) || valid.NameEn(name.value)){
			name.setAttribute("style", "color: green");
		}	
})

document.querySelector("#email").addEventListener("input",function(event){
	console.log(email.value);
	console.log(valid.Email(email.value));
	if(!valid.Email(email.value)){
		email.setAttribute("style", "color: red");
	}
		if(valid.Email(email.value)){
			email.setAttribute("style", "color: green");
		}	
})


document.querySelector("#dbCheckId").addEventListener("click", function(event) {
	if (!document.querySelector("#id").value) {
	} else {
		let pop = window.open("/user/userCheck.jsp?id=" + document.querySelector("#id").value, "pop", option);
	}
})
