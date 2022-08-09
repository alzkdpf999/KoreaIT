import { Careful } from "./Careful.js";
let careful = new Careful();
let ssn = opener.document.querySelector("#ssn").value;
let name = opener.document.querySelector("#name").value;
let kr = opener.document.querySelector('#kr').value;
let en = opener.document.querySelector('#en').value;
let ma = opener.document.querySelector('#ma').value;
let h4 = document.createElement('h4');
let txt;
let out = opener.document.querySelector("#table").value;

if (ssn == '' || name == '' || kr == '' || en == '' || ma ==''  ) {
    txt = document.createTextNode(`정보를 전부 입력해주세요`);
    document.querySelector("#check").addEventListener("click", function (event) {
        self.close();
    })
}else if (out != -1){
    txt = document.createTextNode(`<${ssn}> ${name}님을 이미 존재합니다.`);
    document.querySelector("#check").addEventListener("click", function (event) {
        self.close();
    })
}else {
    txt = document.createTextNode(`<${ssn}> ${name}님을 등록하시겠습니까?`);
    document.querySelector("#cancle").addEventListener("click", function (event) {
        careful.closePop("cancle");
    })
    document.querySelector("#reg").addEventListener("click", function (event) {
        careful.closePop("reg");
    })
}
h4.appendChild(txt);

document.querySelector("#case").prepend(h4);


