// function 함수이름 (매개변수...)

function add (a, b){
    return a + b;
}


var sum = add(1, 2);
console.log("sum =", sum);


// JS 에선 '함수(function)' 도 데이터 입니다하 !!      ㅇ ㅣ  ㄱ ㅔ  몬 소 리 ?
console.log(typeof add)
console.log(add)

// 함수도 데이터다! 따라서,
// 함수를 변수에 대입할수도 있고
// 함수를 매개변수로 넘겨줄 수도 있고
// 함수를 리턴할 수도 있다.
// -----------------------------------------

// JS 는 함수 정의시 아래와 같은 표현을 더 선호함
var add = function(a, b){ // 함수를 만들어서 그걸 add 에 담은 것 .   이렇게 할 수 있구나.
    return a + b;
}

var sub = function(a, b){  // 이름없는 함수가 생성되고, 이걸 sub 에 담으면 ->  sub는 이 함수를 동작하는 함수가 된다. 
    return a - b;
}
console.log(sub(10,3))


let mul = function(a, b){return a * b; }
console.log(mul(4, 5))


let bbb = mul; // mul 의 타입은? function. 그걸 bbb 에 담았어. 그럼 bbb 타입은? function 타입이 된다. 
console.log(bbb(100,2))



// 함수들을 담고 있는 배열을 만들어 보자
var arr = [add, sub, mul];

console.log(arr[0](10, 20))
console.log(arr[1](10, 20))
console.log(arr[2](10, 20))




