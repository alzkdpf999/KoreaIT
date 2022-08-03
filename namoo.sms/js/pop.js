import {Careful} from "./Careful.js";

let careful =new Careful();
// document.querySelector("#ssn").addEventListener("click",function(event){
//     self.close();
// })
// document.querySelector("#name").addEventListener("click",function(event){
//     self.close();
// })
// document.querySelector("#kr").addEventListener("click",function(event){
//     self.close();
// })
// document.querySelector("#en").addEventListener("click",function(event){
//     self.close();
// })
// document.querySelector("#math").addEventListener("click",function(event){
//     self.close();
// })
// document.querySelector("#avg").addEventListener("click",function(event){
//     self.close();
// })

document.querySelectorAll("#sort")[0].addEventListener("click",function(event){
    console.log(this.value);
    careful.closeCenter(0);
})
document.querySelectorAll("#sort")[1].addEventListener("click",function(event){
    console.log(this.value);
    careful.closeCenter(1);
})
document.querySelectorAll("#sort")[2].addEventListener("click",function(event){
    console.log(this.value);
    careful.closeCenter(2);
})
document.querySelectorAll("#sort")[3].addEventListener("click",function(event){
    console.log(this.value);
    careful.closeCenter(3);
})
document.querySelectorAll("#sort")[4].addEventListener("click",function(event){
    console.log(this.value);
    careful.closeCenter(4);
})
document.querySelectorAll("#sort")[5].addEventListener("click",function(event){
    console.log(this.value);
    careful.closeCenter(5);
})
