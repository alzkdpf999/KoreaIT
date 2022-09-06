document.querySelector("#recipe_sequence").addEventListener("click",function(event){
  if (event.target && event.target.id == 'add'){
  
  if(document.querySelectorAll("#seq_num").length >= 6){
    document.querySelector("#add").setAttribute("disabled", "disabled");
  }else{
    let input = document.createElement("input");
  input.className = 'form-control';
  input.setAttribute("type","text");
  input.setAttribute("name","seq_num");
  input.setAttribute("id","seq_num");
  document.querySelector(".thrid").after(input);
  }
  if(document.querySelector("#del").getAttribute("disabled")){
    document.querySelector("#del").removeAttribute("disabled");
  }
  console.log(document.querySelectorAll("#seq_num").length);
}else if(event.target && event.target.id == 'del'){
  if(document.querySelector("#add").getAttribute("disabled")){
    document.querySelector("#add").removeAttribute("disabled");
  }
  if(document.querySelectorAll("#seq_num").length <= 3){
    document.querySelector("#del").setAttribute("disabled", "disabled");
  }else{
    let input =document.querySelector('#sequence input:last-child');
  let parent = input.parentElement;
  parent.removeChild(input);
  }
  
}
})