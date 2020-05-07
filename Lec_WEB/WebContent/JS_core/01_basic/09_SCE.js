// 논리 연산자
// && and  연산자 
// || or 연산자
// ! not 연산자 

// 논리연산자를 이용한 조건문 실행
// Short Circuit Evaluation

// 표현식1 && 표현식2
//  표현식1 이 Falsy 이면 && 의 결과값은 표현식1
//  표현식1 이 Truthy 이면 && 의 결과값은 표현식2

// 표현식1 || 표현식2
//  표현식1 이 Falsy 이면 && 의 결과값은 표현식2
//  표현식1 이 Truthy 이면 && 의 결과값은 표현식1



console.log(true && true)
console.log(true && false)

let a = 100
console.log(a > 10 || a + 10 < 10) // T 왼쪽의 결과가 나옴
console.log(a < 10 || a + 10 < 10)  // 왼쪽이 F 이므로 오른족의 결과가 나옴

console.log(a > 10 && a + 10 < 10)
console.log(a < 10 && a + 10 < 10)

console.log("Hello" || "world")  // 왼쪽이 결과값이다. 자바랑 다름. 자바는 무조건 논리연산자는 무조건 블린으로 나왔다.

console.log(0 || "world")  // 왼쪽이 먼저 0 으로 false 됨. 그러면 오른쪽의 값이 어떠한 값이든 상관없이 오른쪽 결과값이 출력된다.

console.log(5 && 100)
console.log(5 && 0) //왼쪽이 참이면 무조건 오른쪽이 참이든 거짓이든 오른쪽 값이 나온다. 

console.log(null && 'hello') // 왼쪽이 거짓이면 무조건 왼쪽 값이 나온다. 
console.log(100 - 100 && [10, 20, 30])  

// 왼쪽이 참이면 무조건 왼쪽값이 출력된다. 



let n = 15;
(n % 5 == 0) && console.log('5의 배수입니다')

n = 7;
(n % 5 === 0) || console.log('5의 배수가 아닙니다')

/* 오른쪽 값이 수행되는 경우 
&&  : 왼쪽이 참일땐 오른쪽 값이 수행되고
|| : 왼쪽이 거짓일 때 오른쪽 값이 수행된다. 
 */


