document.querySelector("#ok").addEventListener("click",function(event){
  let val = document.querySelector("#id").value;
  opener.document.querySelector("#id").value = val;
})