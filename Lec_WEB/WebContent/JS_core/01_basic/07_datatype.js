// 자료형 : data type

//  https://developer.mozilla.org/ko/docs/Web/JavaSCript/Data_structures

// 동적타이핑 (dynamic type)
// 변수는 고정타입이 없다

// runtime 에 개발자가 모르는 어떤 타입의 값이
// 들어올수 있다  주의!

// 데이터 타입
// 1.기본타입 (primitive)
//  -- boolean
//  -- null
//  -- undefined
//  -- number
//  -- string
//  -- symbol (ES6 에 추가)
//
// 2. 객체 (object)
//   ..

//------------------------------------------------------------------------------
// boolean 타입
// true / false 
{
    const isTrue = true
    const isFalse = false

    console.log(`isTrue = ${isTrue}`, typeof isTrue)
    console.log(`isFalse = ${isFalse}`, typeof isFalse)

    if (isTrue) {
        console.log(isTrue, '참 입니다')
    } else {
        console.log(isFalse, '거짓입니다')
    }

    // 데이터 타입을 ! =>    객체로 생성 가능하다!  근데 아래와 같은 문제가 생기므로 가능하면 사용하지 말자 
    // 가능은 하지만 비추다..

    const a = new Boolean(false); // false 값을 갖는 Boolean 객체 
    console.log(`a = `, a, typeof a)

    if (a) { // <- new 를 사용하여 생성하면 조건식에서 '참' 으로 판정된다!!!? 
        console.log(a, '참입니다')
    } else {
        console.log(a, '거짓입니다')
    }





    //  new 를 사용하지 않고  boolean 만들기
    const b = Boolean(false) //  Boolean() 함수 
    // 자스는 객체 지향 언어가 아니므로, 함수가 객체 역할을 한다. 
    // 이 함수는 블린 타입이다
    console.log('b = ', b, typeof b)

    if (b) { // <- new 를 사용하여 생성하면 조건식에서 '참' 으로 판정된다!!!? 
        console.log(b, '참입니다')
    } else {
        console.log(b, '거짓입니다')
    }
}


//------------------------------------------------------------------------------
// null 타입
// 값이 없는 object
console.log('\n<null>') 
{

    const a = null;
    console.log('a = ', a, typeof a) // null 의 타입은 오브젝트!! (기억!!)

}

//------------------------------------------------------------------------------
// undefined 타입
// 아무 값도 대입 안 된 상태의 타입이다.
{
    let b; // 아무 값도 대입 안 된 상태, undefined
    console.log('b = ', b, typeof b)

    let a = 10;
    a = undefined // 다시 undefined 로 대입 가능하다 
    console.log('a = ', a, typeof a)

    a = null;
    b = undefined;
    if (a == b) { // == : 값이 같은지만 비교!
        console.log('== 같습니다'); // == 같습니다.
    } else {
        console.log('== 다릅니다')
    }


    if (a === b) { // === : 값 뿐만 아니라 type 까지 비교  ( === 세개 써야 한다!!)
        console.log('== 같습니다'); // == 같습니다.
    } else {
        console.log('== 다릅니다')
    }
    // 가급적 JS 프로그래밍에 작성 시 == 보단 ===(3개) 추천
    // != 보단 !== 추천!! 

    // 자스에는 비교 연산 두가지가 있다.값만 비교하는 경우와 값뿐만 아니라 타입까지 비교하는 것도 있다.
}

//------------------------------------------------------------------------------
// number
console.log("\n<number>") 
{
    const a = 37;
    console.log('a = ', a, typeof a)
    const b = 3.14
    console.log('b = ', b, typeof b)

    const c = NaN; // Not a Number
    console.log('c=', c, typeof c)

    let d = Number(123)
    console.log('d = ', d, typeof d) // number

    d = Number('123') // number  로 형변환 됨! 
    console.log('d = ', d, typeof d)

    d = Number('Mark') // number  로 형변환 됨! 
    console.log('d = ', d, typeof d) // number 타입으로 변환할 수 없는 경우 --> NaN 난 타입으로 정해주자. 

    d = parseInt('123') // 이 또한 number 로 형변환 된다
    console.log('d = ', d, typeof d)


    d = parseInt('Alice')
    console.log('d = ', d, typeof d) // NaN   
    // 자바에서는 넘버로 형변환 하려고 했으ㄹ 때 파스 안되면? 익셉션 발생. 근데 자스에서는 NaN 타입 으로 나온다! 

    d = parseFloat('3.14') // number 로 형변환
    d *= 2
    console.log('d = ', d, typeof d)


    d = parseInt('3.14') // '3.14' -> 3 으로 형변환
    console.log('d = ', d, typeof d)

    d = parseFloat('300') // 파이썬의 경우 300.0 으로 나온다! 
    console.log('d = ', d, typeof d)

    num1 = 100;
    num2 = '100'

    if (num1 == num2) { // == <-- 값 을 비교 
        console.log(`${num1} == ${num2} 같다`);
    } else {
        console.log(`${num1} == ${num2} 다르다`);
    }


    if (num1 === num2) { // === <-- 값 과 타입을  비교 
        console.log(`${num1} === ${num2} 같다`);
    } else {
        console.log(`${num1} === ${num2} 다르다`);
    }

}
//---------------------------------------------------------------------
// string (문자열)
// ' ~ ', " ~ "
console.log('\n<string>') 
{
    let a = 'Mark'
    console.log('a =', a, typeof a)

    a = "Mark"
    console.log('a =', a, typeof a)

    // She's gone 출력은 ?
    a = "She's gone";
    console.log('a =', a, typeof a)

    // He says "Hello"
    a = 'He says "Hello"';
    console.log('a =', a, typeof a)

    // He says "I'm fine"
    a = "He says \"I'm fine\""
    console.log('a =', a, typeof a)

    //+ 문자열 연산
    let b = a + "Hamill"
    console.log('b =', b, typeof b)

    console.log(a * 2) // NaN 

    // 문자열 비교연산 가능! 코드순 비교 
    console.log("a" > "b")
    console.log("a" < "b")
    console.log("abc" < "abd")
    console.log("AAaa" > "AaAa") // false : 대문자 < 소문자    
}


//-------------------------------------------------
// symbol
// ES6 부터 출현
// https://developer.mozilla.org/ko/docs/Glossary/Symbol

// '고유'한 값을 만들어낼때 사용
console.log('\n<symbol>');
{
    const a = Symbol();  // new 사용하면 안됨. Symbol is not a constructor  -> 함수가 곧 객체임.
    const b = Symbol(37);   // Symbol(매개변수)
    const c = Symbol('Mark');
    const d = Symbol('Mark');  // c, d 는 같은 것이 아니다. 
                            //  '고유' 한 Symbol 객체로 만들어 진다.  ==> 그러므로 c와 d 비교하면 서로 다르다고 나온다! 이게 일반 문자열 비교랑 다른 점!!



    console.log('a =', a, typeof a);
    console.log('b =', b, typeof b);
    console.log('c =', c, typeof c);
    console.log('d =', d, typeof d);


                    // symbol 은 다르다고 나온다 "false!!"
    console.log(c == d)
    console.log(c === d)



        // 일반 문자열    ==> 같다고 나온다  " true!"
        let e = 'Mark', f = 'Mark';
        console.log(f == e)
        console.log(f === e)

}


console.log("\n프로그램종료\n\n\n\n\n\n\n\n\n\n\n");



























