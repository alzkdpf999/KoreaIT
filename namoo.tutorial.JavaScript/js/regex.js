"use strict";

// RegExp 주요 함수
(function () {
  let message ='Hello world, JavaScript';
  let regex = new RegExp("Java");
  let result = regex.exec(message);
  console.dir(result);
  console.log(regex.test(message));
})();

// 배열 반환
(function () {
  let message ='Hello world, JavaScript';
  let regex = /Java/gm;
  let result = message.match(regex);
  console.dir(result);
})();

// 인덱스 반환
(function () {
  let message ='Hello world, Java JavaScript';
  let regex = /Java/gm;
  let result = message.search(regex);
  console.dir(result);
})();

// 문자열 교체
(function () {
  let message ='Hello world, Java JavaScript';
  let regex = /Java/gm;
  let result = message.replace(regex, 'JavaScript');
  console.dir(result);
})();

// 문자열 분리하여 배열 반환
(function () {
  let message ='Hello world, Java JavaScript';
  let regex = /,/gm;
  let result = message.split(regex);
  console.dir(result);
})();
