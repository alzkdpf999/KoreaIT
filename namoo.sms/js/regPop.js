import {Careful} from "./Careful.js";
let careful=new Careful();

let ssn =opener.document.querySelector("#ssn").value;
let name =opener.document.querySelector("#name").value;
let h4 = document.createElement('h4');
let txt= document.createTextNode(`<${ssn}> ${name}님을 등록하시겠습니까?`);
h4.appendChild(txt);
console.log(h4);
document.querySelector("#case").prepend(h4);

document.querySelector("#reg").addEventListener("click",function(event){
    
    careful.closePop("reg");
})
document.querySelector("#cancle").addEventListener("click",function(event){
    careful.closePop("cancle");
})
