import { Careful } from "./Careful.js";

let careful = new Careful();
let h4 = document.createElement('h4');
let txt;
let out = opener.document.querySelector("#table").value;
if (out == -1) {
    txt =document.createTextNode(`학생이 존재하지 않습니다.`);
    document.querySelector("#check").addEventListener("click", function (event) {
        self.close();
    })

} else {
    txt = document.createTextNode(`정렬 방법을 선택해주세요.`);
    
    document.querySelector("#ssnsort").addEventListener("click", function (event) {
        careful.closePop("ssnsort");
    })
    document.querySelector("#namesort").addEventListener("click", function (event) {
        careful.closePop("namesort");
    })
    document.querySelector("#krsort").addEventListener("click", function (event) {
        careful.closePop("krsort");
    })
    document.querySelector("#ensort").addEventListener("click", function (event) {
        careful.closePop("ensort");
    })
    document.querySelector("#mathsort").addEventListener("click", function (event) {
        careful.closePop("mathsort");
    })
    document.querySelector("#avgsort").addEventListener("click", function (event) {
        careful.closePop("avgsort");
    })
}
h4.appendChild(txt);
document.querySelector("#case").prepend(h4);