// if ~ else
// if ~ else if ~ else ..
// JAVA, C 언어와 구조 동일

a = 100

if(a + 1 > 100){
    // console.log('if 안의 a 값은', a)
    // var a = 10;  // var 는 hoisting 되고
    let a = 10; // let 은 안되고,
    console.log('if 안의 a 값은', a)  // a = 10

    // 이런식으로는 사용하지 말고, 해석은 할 수 이써야함.

}

// 조건식에서 참 거짓 판정시 !
// 이때 거짓으로 판정되는건 
//  Falsy 로 평가될때!
// false, 0, '', null, undefined, NaN (블린타입, 숫자, 문자열, 오브젝트, NaN 타입)  <-- 'Falsy 한 값'이라 한다

// Truthy 로 평가될때
// true, 37, 'Mark', {}, []   <-- 'Truthy 한 값' 이라 한다  (비어 있는 오브젝트와 배열을 만들 수 있다 자스는 다르다!!)

function print(data){
    if(data){ // 참(Truthy)  거짓(Falsy) 판정
        console.log(data, typeof data, '-- Truthy');
    } else {
        console.log(data, typeof data, '-- Falsy');
    }
}


print(true)
print(false)
print(100)
print(0) //F
print(-1) //T
print('hello') // T
print("") // F
print([10, 20, 30]) // T
print([])  // T  , ★ 파이썬 과는 다르다!
print({})  // T
print({'name' : 'John', 'age': 32})  // T
print({}) // T  , ★ 파이썬 과는 다르다!
print(null)   // F
print(undefined) // F
print(NaN) // F
console.log(100 / 0)  // Infinity
print(100/0) //  Infinity 는 참 나온다 ~!    // Infinity, number -- Truthy

// 호출할 때 매개변수 넘어가지 않으면 undefined 된다 
print() // 매개변수(전달인자) 없으면 undefined  값으로 동작한다

// 함수가 생성자 역할을 함으로 관례적으로 소문자로 시작하도록 한드아????



console.log()
// Falsy 값에 ! 결과 => true (boolean)
console.log(!undefined)
console.log(!null)
console.log(!0)
console.log(!"")

// Truthy 값에 ! 결과 => false (boolean)
console.log(!3)
console.log(!"Hello")
console.log(!" ")
console.log(![10, 20, 30])
console.log(![])
console.log(!{})


console.log()
// Truthy, Falsy 판정결과 -->  boolean
// 1. 삼항연산자 사용
let value = {'a' : 100}
let isTrue = value ? true : false;  // 어떠한 결과도 블린 타입으로 결과 출력된다. 

console.log('isTrue =', isTrue, typeof isTrue)


// 2. !!  not 연산자 이용
isTrue = !!value;  // not 연산자 2번 적용되는 꼴
console.log('isTrue =', isTrue, typeof isTrue)

console.log()

function printName(person){
    console.log('이름은', person.name)
}

let myBrother = {name : "John"}
printName(myBrother)
// printName() // 에러다 undefined 값이 person 에 넘겨짐
// TypeError: Cannot read property 'name' of undefined  undefined 된 property 에 name 이 없다. 


console.log()
/* 
// 함수 정의할 때 매개변수 체크 필요
function printName(person){

    // 매개변수 null check
    if(person === undefined || person === null) return;

    console.log('이름은', person.name)
}

printName(myBrother);
printName();
 */
// 이렇게 할 수도 있는데!  간단하게 하쟈 
// 함수 정의할때 매개변수 체크 필요
function printName(person){
    if(!person) return;   // 간단하게 해결

    console.log('이름은', person.name)
}

printName(myBrother);
printName();





console.log("\n프로그램종료\n\n\n\n\n\n\n\n\n\n\n");











































