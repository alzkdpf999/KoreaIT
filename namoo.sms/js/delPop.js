import { Careful } from "./Careful.js";
let careful = new Careful();
let ssn = opener.document.querySelector("#ssn").value;
let name = opener.document.querySelector("#name").value;
let h4 = document.createElement('h4');
let txt;
let out = opener.document.querySelector("#table").value;


if (ssn == '' || name == '') {
    txt = document.createTextNode(`학번과 이름을 입력해주세요`);
    document.querySelector("#check").addEventListener("click", function (event) {
        careful.closePop("check");
    })
}else if (out == -1) {
    txt = document.createTextNode(`<${ssn}> ${name}님은 존재하지 않습니다.`);
    document.querySelector("#check").addEventListener("click", function (event) {
        self.close();
    })
} else {    
    txt = document.createTextNode(`<${ssn}> ${name}님을 삭제하시겠습니까?`);
    document.querySelector("#cancle").addEventListener("click", function (event) {
        careful.closePop("cancle");
    })
    document.querySelector("#remove").addEventListener("click", function (event) {
        careful.closePop("remove");
    })
}

h4.appendChild(txt);

document.querySelector("#case").prepend(h4);


