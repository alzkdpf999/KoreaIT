import { Careful } from "./Careful.js";
let careful = new Careful();

let h4 = document.createElement('h4');
let txt;
let out = opener.document.querySelector("#table").value;

if(out){
    txt = document.createTextNode(`전체 삭제하시겠습니까?`);
    document.querySelector("#cancle").addEventListener("click", function (event) {
        careful.closePop("cancle");
    })
    document.querySelector("#removeall").addEventListener("click", function (event) {
        careful.closePop("removeall");
    })
    
}else{
    txt = document.createTextNode(`학생들이 존재하지 않습니다.`);
    document.querySelector("#check").addEventListener("click", function (event) {
        self.close();
    })
    
    
}
h4.appendChild(txt);
document.querySelector("#case").prepend(h4);

