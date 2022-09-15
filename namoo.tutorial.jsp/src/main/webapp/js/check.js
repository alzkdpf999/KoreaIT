import { Validitycheck as valid } from "/js/Validitycheck.js";

let option = "width=400,height=250,left=700,top=400,scrollbars=no";
let id = document.querySelector("#id");
let passwd = document.querySelector("#passwd");
let name = document.querySelector("#name");
let email = document.querySelector("#email");

document.querySelector("#signup").addEventListener("submit", function(event) {
	document.querySelector("#dbCheckId").removeAttribute("disabled");



	if (!valid.Email(email.value) || valid.isNull(email.value)) {
		console.log(valid.Email(email.value));
		email.focus();
		email.setAttribute("style", "color: red");
		event.preventDefault();
	} else {
		email.removeAttribute("style");
	}
	if (valid.isNull(name.value) || (!valid.NameKr(name.value) && !valid.NameEn(name.value))) {
		console.log((!valid.NameKr(name.value) || !valid.NameEn(name.value)));
		name.focus();
		name.setAttribute("style", "color: red");
		event.preventDefault();
	} else {
		name.removeAttribute("style");
	}
	if (valid.isNull(passwd.value) || !valid.Passwd(passwd.value)) {
		passwd.focus();
		document.querySelector("#passwdErr").setAttribute("style", "color: red");
		event.preventDefault();
	} else {
		passwdErr.removeAttribute("style");
	}
	if (valid.isNull(id.value) || !valid.Id(id.value)) {
		id.focus();
		document.querySelector("#idErr").setAttribute("style", "color: red");
		event.preventDefault();
	} else {
		idErr.removeAttribute("style");
	}
})

document.querySelector("#dbCheckId").addEventListener("click", function(event) {
	if (valid.isNull(id.value) || !valid.Id(id.value)) {
		document.querySelector("#idErr").setAttribute("style", "color: red");
	} else {
		let pop = window.open("/user/userCheck.jsp?id=" + document.querySelector("#id").value, "pop", option);
		idErr.removeAttribute("style");
	}
})
/*	document.querySelector("input#id").addEventListener("keyup", function(){
		if(document.querySelector("input#id").value.length < 6 || document.querySelector("input#id").value.length > 8){
			document.querySelector("#idErr").innerHTML = "아이디 6~8자 사용가능"
		}else{		
		let user = {
			id : document.querySelector("input#id").value
		};
		const option = {
			method: "post",
			headers: {
				"Content-Type": "application/json",
			},
			body: JSON.stringify(user),
		}
		fetch("userCheckAjax.jsp", option)
			.then(response => response.json())//아래의 response와 다른 response임
			.then(response => {
				if(response.result){
					document.querySelector("#idErr").innerHTML = `사용가능`;
				}else{
				document.querySelector("#idErr").innerHTML = `사용불가`;	
				}
			})
			.catch(error => console.log("hi"));
		}
	
	});*/
