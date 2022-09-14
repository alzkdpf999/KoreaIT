
const regId = /^[a-zA-Z]+[a-zA-Z0-9]{3,11}$/;
const regPasswd = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$/;
const regEmail = /[a-zA-Z0-9._+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9.]+/gm;
const regNameKr = /[가-힣]{2,5}$/;
const regNameEn = /[a-zA-Z]{2,5}$/;
let Validitycheck = {};

Validitycheck.Id = function(id) {
	return regId.test(id);
}


Validitycheck.Passwd = function(passwd) {
	return regPasswd.test(passwd);
}

Validitycheck.Email = function(email) {
	return regEmail.test(email);
}

Validitycheck.NameKr = function(name) {
	return regNameKr.test(name);
}

Validitycheck.NameEn = function(name){
	return regNameEn.test(name);
}

Validitycheck.isNull = function(value){
  return (value == undefined || value == '');
}
export { Validitycheck };