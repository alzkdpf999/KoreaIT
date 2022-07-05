'use strict'
let now = new Date();
console.dir(now);
console.log(now.getFullYear());
console.log(now.getMonth()+1);
console.log(now.getDate());
console.log(now.toLocaleString());

console.log(now.getTime());
let nowtime = now.getTime(); //현재까지 시간
let someDay = new Date(1987,3,2);
let someTime = someDay.getTime(); //1987-03-02시까지 시간 
let time = nowtime - someTime;
console.log(parseInt(time/ (24 * 60 *60 *1000))) ;

let date = new Date();
let date1 = date.getDate();
date.setDate(date1-1);
console.log(date.toLocaleString());
console.log(date.getDay());