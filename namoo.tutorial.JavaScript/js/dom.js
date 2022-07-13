let array = document.getElementsByTagName('p');
console.dir(array);
for(const element of array){
  console.log(element);
}
let ele = document.querySelector("li:first-child");
console.log(ele);
ele.style.backgroundcolor
ele.style['backgroundcolor'] = 'gold'

let list3 = document.querySelectorAll("li:nth-child(2n+1)");
/* for (const li of list3){
  li.style.display= 'none';
} */
let body = document.querySelector("#dom").parentElement;

body.style.backgroundColor = 'gray';

alert(body.children.length);
let li = document.createElement('li');
let txt = document.createTextNode('screen');
li.appendChild(txt);
document.querySelector('#bom').appendChild(li);