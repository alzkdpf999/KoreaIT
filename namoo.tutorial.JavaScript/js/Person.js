class Person {
  // private 속성
  #password = 100;
  //공유 속성 및 메소드
  static address = "대한민국";
  static shareMethod(){
    console.log("공유메소드 실행");
  }
  constructor(name, age) {
    //this = {};
    this.name = name; // this.name은 여기서 get name을 name은 set name(name)을 실행
    this.age = age;
    // return this;
  }
  speak() {
    console.log(`${this.name}: hello~~`);
    console.dir(this);
  }
  //[setter/gettter] 추가 
  get name() {
    return this._name; // 여기서 언더바를 안쓰면 자기 자신을 호출함(무한 재귀) 그래서 언더바를 씀
  }
  set name(name) {
    if (name == undefined) {
      throw Error("이름을 입력하세요");
    }
    this._name = name; // 실제 넣을 값이 this._name 에 들어감
  }
  get age() {
    return this._age; //
  }
  set age(age) {
    if (age == undefined) {
      throw Error("나이를 입력하세요");
    }
    if (age < 0) {
      this._age = 0;
    }else {
      this._age = age;
    }
  }
}

let person = new Person('jack', 30);
person.speak();

console.log(Person.address);
Person.shareMethod();
console.log(person.address);//undefined 
// person.shareMethod();
console.log(person.password);//undefined 
console.log(Person.password);//undefined 
