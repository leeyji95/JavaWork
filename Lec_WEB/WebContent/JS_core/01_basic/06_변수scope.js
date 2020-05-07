// 변수의 유효범위
// scope

// const, let 의 유효범위
//  ==> Block Scope
//    { ... }    -> 블록 안에서만 유효하다

// 블럭
{
    const name = 'Mark' // 블럭 안에서만 사용가능
    console.log(`name = ${name}`)

}

// 블럭 밖에서 사용하려 하면 에러!
// console.log(`name = ${name}`)

{
    // console.log('name = ', name)  // 초기화가 안되었다고 에러!! 
    const name = 'Mark' 
    // A const variable cannot be used before it is declared:
}


{  // 선언된 블럭 전체에서 사용가능!!  
    console.log('value1 = ', value1);  
    // 에러 아니다. undefined 가 나올뿐.   이미 블럭 어딘가에서 선언이 되었기 때문에. value1 는 존재하는거.  // 여기서 이미 선언이 되었고, value1 이 존재한다. 그러나 아직 값이 정해지지 않은 것 
    var value1 = 200;

    // console.log('value2 = ', value2);   // 얘는 에러. 왜? 블럭 안에서 선언된 적이 없거등
}

// 자바는 선언한 이후부터 존재하나, 
// 자스는 같은 블럭 내에 있으면 선언이 된다.!!!!
// 

//-------------------------- 점심시간 이후  ------------------------------------------------------------
// Hoisting
// https://developer.mozilla.org/ko/docs/Glossary/Hoisting

//  출력,  밑에서 선언된 걸 끌어올림-> 이걸 호스팅이라고 함. 
/* JavaScript는 초기화가 아닌, 선언만 끌어올린다.(hoist)
 만약 변수 선언 뒤, 나중에 초기화시켜 사용한다면 -> 그 값은 undefined 로 지정됨  

 ex) 
var x = 1; // x 초기화
console.log(x + " " + y); // '1 undefined'
var y = 2;

*/


// 이러한 현상을 hoisting 이라 하는데
// hoisting 현상은 함수에서만 발생하는게 아니다.

// hoising 
// 아래에 있는 선언을(만) 끌어올린다.

// hoising 때문에 동작의 오류처럼 보이는 증상 겪게 됨

// hoising 현상은 처음부터 있었으나
// 용어 자체는 ES2015 및 그 이전에는 사용되지 않음


{
    console.log(`nick=${nick}`); // 2. 가 hosting 됨.   hosting 은 선언만 끌어올린다(JavaScript only hoists declarations, not initializations.)

    nick = 'Mighty';  // 1.    초기화
    console.log(`nick=${nick}`); // 1.   
    var nick = '아이언맨';  // 2.         


    // var 변수선언 안하고 초기화만 하면 다음 순서의 console로 가고,
    // var 변수선언을 해주면 ->  상위 console 로 찾아 올라간다(to the top of the current scope)  -> 이게 hoisting 의 개념


    // 1. nick 과 2.ncik 은 변수선언된 scope 가 다르다

}

// 해결 : Declare Your Variables At the Top !  걍 scope  top에서 변수들 선언해라!!












// 이 영역은 모지> var 는 scope 블록 바깥쪽의 변수 사용이 가능한가? 
age = 6;
age++;
console.log('1. age=', age) // 7


{
    console.log(`2. age = ${age}`)  //  블럭 바깥쪽 scope 의 변수 사용 가능.  // 7 
    age = 30  // 30 으로 다시 초기화
    console.log(`3. age = ${age}`)   // 30 
    var age; // var 는 hoisting 발생   // 여기서(scope 어딘가에서) var 키워드로 age 변수 선언!!  -> hoisting 발생하여 scope top으로 올라가 값을 찾아간다.
    // let age;   // let 은 hoisting  이 발생 안한다.    ==> let과 const 는 초기화 먼저 해주고 오자...( 내가 공부한 결과..)
}

   console.log(`4. age = ${age}`) // 






















