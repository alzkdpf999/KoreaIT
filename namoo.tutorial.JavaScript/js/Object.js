//객체표현식을 이용한 객체 생성

let myDog ={
    name: 'jack',
    age: 5,
    kind: '비숑',
    eat : function(){
        console.log("잘 먹습니다.");
    }
};

console.log(myDog.name);
console.log(myDog['age']);
myDog.eat();
myDog['eat']();
console.log(myDog.color);
let color = myDog.color || 'black';
console.log(color);

//속성 추가
myDog.color= 'white';
//속성 삭제
delete myDog.age;
console.log(myDog['age']);
console.log(myDog['color']);
console.dir(myDog); //객체안에 한번에 출력하기 위해 디버깅할 때 중요


//속성이나 메소드 존재 여부
console.log('name' in myDog);
console.log('age' in myDog);

// for-in(객체나 배열 반복)
for (const key in myDog) {
    console.log(`${myDog[key]}: ${key}`);
}

//팩토리 함수 
function createDog(name, age , kind){
    return {
        name : name,
        age : age,
        kind : kind,
        eat: function(){
            console.log("siasisai");
        }
    }
}

let yourDog =createDog('두부',3,'비숑');
console.dir(yourDog);