
const logins = document.querySelectorAll(".login")
for (const login of logins) {
	login.addEventListener('load', function(event) {
		if(login.classList.contains(err))
		login.classList.remove("err");
	})
}