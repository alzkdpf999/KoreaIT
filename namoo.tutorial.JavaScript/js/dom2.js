// 돔 객체 생서
let li = document.createElement('li');
let txt = document.createTextNode('Screen');
li.appendChild(txt);
document.querySelector('#bom').appendChild(li);

let nums = "";
for (let index = 0; index < 10; index++) {
  nums+= `<li>${index}</li>`;
  
}
document.querySelector('#number').innerHTML = nums;

let img = document.createElement('img');
img.setAttribute('src', '/images/bg1.jpg');
img.setAttribute('width', '100px');
img.setAttribute('height', '100px');
document.querySelector('body').appendChild(img);
// img.removeAttribute('width');
// img.removeAttribute('height');

let cloneNode = document.querySelector("#bom").cloneNode(true);
//true를 빼버리면 자식은 복사 안됌
document.querySelector('body').appendChild(cloneNode);


let h2 = document.querySelectorAll('h2');

h2.forEach(element=> {
  //인라인 방식 동적 적용
  console.log(element);
  element.style.backgroundColor = 'blue';
  element.style.color = 'white';
  element.style.border = '2px dotted red';
});

let spans = document.querySelectorAll("span");
spans.forEach(element => {
  element.className = "some";
})
