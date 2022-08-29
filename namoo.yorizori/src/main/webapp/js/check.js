import { Validitycheck as valid } from "./Validitycheck.js";

let option = "width=450,height=250,left=700,top=400,scrollbars=no";

document.querySelector(".signupId").addEventListener("input", function(event) {
	document.querySelector("#ok").value = "unCheck"
	document.querySelector("#dbCheckId").removeAttribute("disabled")
	document.querySelector("#signOk").setAttribute("disabled", "disabled")
})
if (document.querySelector("#ok").value == "unCheck") {
	document.querySelector("#signOk").setAttribute("disabled", "disabled")
}


document.querySelector("#signup").addEventListener("submit", function(event) {

const id = document.querySelector(".signupId").value;
const passwd = document.querySelector(".validPasswd").value;
const name = document.querySelector("#name").value;
const email = document.querySelector("#email").value;


	if (!valid.Email(email)) {
		document.querySelector("#email").focus();
		document.querySelector("#email").classList.add("err");
		event.preventDefault();
	} else {
		document.querySelector("#email").classList.remove("err")
	}
	if (!(!valid.NameKr(name) || !valid.NameEn(name))) {
		console.log(!valid.NameKr(name) || !valid.NameEn(name));
		document.querySelector("#name").focus();
		document.querySelector("#name").classList.add("err");
		event.preventDefault();
	} else {
		document.querySelector("#name").classList.remove("err")
	}
	if (!valid.Passwd(passwd)) {
		document.querySelector(".validPasswd").focus();
		document.querySelector("#passwdErr").setAttribute("style", "color: red");
		event.preventDefault();

	} else {
		passwdErr.removeAttribute("style");
	}
	if (!valid.Id(id)) {
		document.querySelector(".signupId").focus();
		document.querySelector("#idErr").setAttribute("style", "color: red");
		event.preventDefault();
	} else {
		idErr.removeAttribute("style");
	}
})


document.querySelector("#dbCheckId").addEventListener("click", function(event) {
	const id = document.querySelector(".signupId").value;
	console.log(id);
	if(valid.isNull(id)){
		document.querySelector("#idErr").setAttribute("style", "color: red");
	}
	if(!valid.Id(id)){
		document.querySelector("#idErr").setAttribute("style", "color: red");
		if(valid.Id(id)){
		document.querySelector("#dbCheckId").removeAttribute("disabled");
		let pop = window.open("/yorizori/user/check.do?id=" + id, "pop", option);
		idErr.removeAttribute("style");
		
		}
	}
	
})
