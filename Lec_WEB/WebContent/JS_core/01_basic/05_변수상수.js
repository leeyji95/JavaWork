// var, let, const

var a = 100;
console.log('a=', a)   // 100
a = 200
console.log('a=', a)  // 200

var a = 500; // 중복 선언 가능!!(변수)
console.log('a=', a)  // 500

// ES6 부터 let, const 로 변수 상수 지정.  이걸로도 변수 선언 가능하게 되었다
let value = 177;
console.log('value=', value); // 177
value = 555;
console.log('value=', value);  // 555

// 중복 선언 불가! 동일 이름 변수 let 으로 선언 불가
// let value= 277;


// 상수선언
const b = 1;
console.log('b=', b)
// b = 2; // 오류
// console.log('b=', b)




//---------------------------------------------------------------------------
// var 는 오늘날 js 환경에서는  그닥  권장하진 않음

// var 와 let
// IE9, IE10  와 같은 구형 브라우저에서는
//  let, const 를 사용 못함.

// 개발 단계에서는 '바벨' 등을 사용하여
// 우리가 개발한 코드가 구형 브라우저 에서도 동작케 함.




let c; // 초기화를 따로 해도 가능/
c = 100;

//  ` : back tick   (이거 자스에서 많이 사용!)
console.log(`c = ${c}`); // Template literal (ES6 <= )
// 위에서 선언된 c 값이 쏙 들어간다!  이때 back tick 을 사용한다는 것 . 

// 데이터 타입들 
let value2 = 100; // number 타입

console.log(value2, typeof value2); // typeof 연산자 : 변수의 타입 
console.log(value2, typeof (value2)); // 이렇게도 동작.. 마치 함수처럼.. 근데 굳이.. ㅂㅊ

// JS 는 대입되는 값에 따라 '타입' 바뀜. 
value2 = 'hello' // string 타입
console.log(value2, typeof value2)

// 대입되는 값에 따라 타입이 계속 바뀔 수 있는 언어이다. 자스가
value2 = "Hello" // '~'. "~" 둘 다 가능하다 
