document.querySelector("#recipe_sequence").addEventListener("click",function(event){
  if (event.target && event.target.id == 'add'){
  let input = document.createElement("input");
  input.className = 'form-control';
  input.setAttribute("type","text");
  input.setAttribute("name","seq_num");
  input.setAttribute("id","seq_num");
  document.querySelector(".thrid").after(input);
  if(document.querySelectorAll("#seq_num").length == 6){
    document.querySelector("#add").setAttribute("disabled", "disabled");
  }
  console.log(document.querySelectorAll("#seq_num").length);
}else if(event.target && event.target.id == 'del'){}
})