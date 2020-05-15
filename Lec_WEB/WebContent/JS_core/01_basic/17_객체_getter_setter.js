/* object 의 getter, setter

getter 함수: 특정 값을 조회할때마다
setter 함수: 특정 값을 설정할때마다

https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Functions/get

ES 5.1 에 최초 정의
https://www.ecma-international.org/ecma-262/5.1/#sec-11.1.5

ES 6 에서 계산된 프로퍼티 이름이 추가
https://www.ecma-international.org/ecma-262/6.0/#sec-method-definitions


JS 에서 매우 유용

*/

const numbers = {
    a: 1,
    b: 2,

     // getter 함수  => 함수가 아니고, 게너이다!!
     get sum() {
        // get 키워드로 시작
        console.log("sum 함수가 실행됩니다");
        // 반.드.시 무엇인가 리턴해주어야 한다. 
        return this.a + this.b ;
        // return 이 빠지면 undefinedflllllllllxjs
    }
}


// getter 함수는 아래와 같이 '조회'하려할 때 
// 그때 함수가 호촐되어 실행된ㄷ.ㅏ
//console.log(numbers.sum()); // 에러!
console.log(numbers.sum);

numbers.b = 5
console.log(numbers.sum);


// setter 함수
const dog = {
    _name : "멍멍이",

    // setter
    // set 키워드로 시작
    set name(value){
        // 반드시 parameter 설정되어야 함!
        console.log("이름이 바뀝니다.." + value);
        this._name = value;
    }

}
console.log();
console.log(dog._name);
//dog.name('뽀삐');  // 에러
dog.name = '뽀삐';   // setter name() 호출
console.log(dog._name);
console.log('---------------------------------------------');


const number2 = {
    _a : 1,
    _b : 2,
    sum : function(){
        return this._a + this._b;
    }
}

numbers2.sum()
_a = 10; _b = 20;
console.log(numbers2.sum());
numbers2._a = 10; numbers2._b = 20;
console.log(numbers2.sum());
console.log(numbers2.sum());
console.log(numbers2.sum());
console.log(numbers2.sum());
console.log(numbers2.sum());
console.log(numbers2.sum());
console.log(numbers2.sum());


const numbers3 = {
    _a : 1,
    _b : 2,
    sum : 3,

    get a() { return this._a },
    get b() { return this._b },
    set a(value){
        this._a = value;
        this.sum = this._a + this._b;
    },
    set b(value){
        this._b = value;
        this.sum = this._a + this._b;
    }

}

console.log('----------------------')
console.log(numbers3.sum);
numbers3.a = 10; // setter 동작, + 연산 발생
numbers3.b = 20; 
console.log(numbers3.sum); // 여러번 조회해도 이미 연산된 결과값만 보여준다. 재계산 하지 않음.
console.log(numbers3.sum);
console.log(numbers3.sum);
console.log(numbers3.sum);
console.log(numbers3.sum);
console.log(numbers3.sum);
console.log(numbers3.sum);


// 조회하는 단계에서 연산을 최소화시켜라  - > 어딘가에 setter 설정해서 성능을 높일 수 있다










