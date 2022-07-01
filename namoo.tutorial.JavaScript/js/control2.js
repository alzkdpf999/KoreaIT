// 이렇게 document.write 하면 tag까지 달아주면 화면에 출력할 수 있게 도와줌

for(let i=2; i<10; i++){
  document.write("<tr>")
  for(let j=1;j<10;j++){
    document.write(`<td>${i} X ${j} =  ${i*j} </td>`);
  }
  document.write("</tr>");
}
