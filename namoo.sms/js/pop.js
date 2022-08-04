import {Careful} from "./Careful.js";

let careful =new Careful();
document.querySelectorAll("#sort")[0].addEventListener("click",function(event){
    careful.closeCenter(0);
})
document.querySelectorAll("#sort")[1].addEventListener("click",function(event){
    careful.closeCenter(1);
})
document.querySelectorAll("#sort")[2].addEventListener("click",function(event){
    careful.closeCenter(2);
})
document.querySelectorAll("#sort")[3].addEventListener("click",function(event){
    careful.closeCenter(3);
})
document.querySelectorAll("#sort")[4].addEventListener("click",function(event){
    careful.closeCenter(4);
})
document.querySelectorAll("#sort")[5].addEventListener("click",function(event){
    careful.closeCenter(5);
})
