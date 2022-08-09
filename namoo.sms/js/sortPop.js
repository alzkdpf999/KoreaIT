import {Careful} from "./Careful.js";

let careful =new Careful();
document.querySelector("#ssnsort").addEventListener("click",function(event){
    careful.closePop("ssnsort");
})
document.querySelector("#namesort").addEventListener("click",function(event){
    careful.closePop("namesort");
})
document.querySelector("#krsort").addEventListener("click",function(event){
    careful.closePop("krsort");
})
document.querySelector("#ensort").addEventListener("click",function(event){
    careful.closePop("ensort");
})
document.querySelector("#mathsort").addEventListener("click",function(event){
    careful.closePop("mathsort");
})
document.querySelector("#avgsort").addEventListener("click",function(event){
    careful.closePop("avgsort");
})
// document.querySelector("#reg").addEventListener("click",function(event){
//     careful.closePop("reg");
// })
// document.querySelectorAll("#cancle").addEventListener("click",function(event){
//     careful.closePop("cancle");
// })
