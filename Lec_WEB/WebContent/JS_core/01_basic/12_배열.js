// 배열 생성 방법

// 방법1 : [ ] 사용
var points = [40, 100, 1, 5, 25, 10];
var fruits = ['Banana', 'Orange', 'Apple', 'Mango']

console.log('points =', points, typeof points);



// 방법2 : new 사용
var cars = new Array("Saab", "Volvo", "BMW");   // 비추
console.log('cars =', cars, typeof cars)

console.log('fruits = ', fruits.toString())  // 문자열로 만들어줍니다, json 변환할떄 유용하게 사용할 수 있따!


// JS 에선 object 의 property 접근 횟수를 줄이는 것이 성능에 유리하다.
console.log()
for(i = 0; i < cars.length; i++){
console.log(cars[i])
}

console.log()
var length = cars.length; // 랭스에 최초의 단 한번만 접근한다.
for(i = 0; i < length; i++){ // 위의 경우보다 좋은 성능을 나타낸다 
console.log(cars[i])
}

// for ~ in : 객체(object)에 대해 사용, property ... 가 사실은 인덱스다.!! 
for(x in cars){  // value 가 아닌 index 가 나옴.
    console.log('x = ', x, cars[x])
}

// for ~ of : ES6부터 사용, iterable 한 객체에 대해 사용가능 
for(x of cars){
    console.log('x = ', x)
}

// 배열. forEach(함수)
// 배열 원소 하나하나 뽑아내면서 함수 호출
var myFunction = function(value){
    console.log(value);
}
cars.forEach(myFunction);  // 각각의 원소값을 mF 로 호출해서 담아서 출력함


// 배열원소 추가
console.log()
fruits[fruits.length] = 'Melon'  // 4번째에 원소 추가
console.log(fruits)

fruits.push('Lemon'); // push 를 더 많이 사용한다
console.log(fruits);

console.log();
// 주어진 변수가 배열인지 아닌지 판단
// typeof만으로는 알 수 없다. 그냥 오브젝트로 나오기 때문

// 1. isArray() : ES5.1 부터 지원.
console.log(Array.isArray(fruits)) // 주어진 변수가 배열이라면 true 로 출력된다

// 2. 구 브라우저에서 판단하려면 함수 만들어서 운영 해야 한다. 
function isArray(x){
    return x.constructor.toString().indexOf("Array") > -1;
}
console.log(isArray(fruits))

// 3. instanceof 연산자
console.log(fruits instanceof Array);

//---------------------------------------------------------------------------
// 배열의 여러개 원소들을 특정 문자(열)로 연결하여 하나의 문자열 묶는다.
// join() <-> split()
// 배열의 원소들을 주어진 문자열로 묶어서 하나의 문자열로 리턴한다.
console.log(cars.join("**"))
console.log([2020, 5, 7].join("/"))


console.log();
// push() : 배열끝 원소 추가
// pop() : 배열 끝 원소 추출
// shift() : 배열 첫 원소 추출
// unshift() : 배열앞에 원소 추가, 새로운 length 리턴
console.log(fruits.toString())  // 현재의 fruits 상태

console.log(fruits.pop()) // 맨 끝의 원소가 나옴
console.log(fruits.toString()) 

console.log(fruits.shift()) // 맨 앞의 원소가 나옴
console.log(fruits.toString()) 

console.log(fruits.unshift('Grape')) // 배열 원소 맨 앞에 추가되며, 새로 추가된 length 를 리턴함
console.log(fruits.toString()) 


console.log()
// splicing (중간 데이터 삽입)
//  첫번째 매개변수 : 삽입될 데이터 위치
//  두번째 매개변수 : 삭제될 데이터 개수
//  세번째 이후 .. : 삽입될 데이터 들..
fruits.splice(2, 0, "Kiwi", "Jadu"); // 2번 인덱스 자리에 데이터 몇 개 삭제할거냐(0) 어떤 데이터 추가할 거냐)___ 2번 앞에서부터 추가됨.
console.log(fruits.toString()) 


fruits.splice(1, 3, "Durian");  // 1번 위치에 데이터 3개를 삭제(1번부터 3개)하고, Durian 을 삽입할 것
console.log(fruits.toString()) 

//concat()  :  --> 원본 변화시키지 않는다.
console.log(fruits.concat(['Lemon', 'Banana']));
console.log(fruits.toString());


fruits = fruits.concat(['Lemon', "Banana"])  // 원본 변화 시키려면 -> 덮어씌워라 
console.log(fruits.toString())

// 배열 데이터 중간을 삭제 하려면??
fruits.splice(1, 3);
console.log(fruits.toString())


// slice()
// 배열의 일부분만 추출, 원본에는 영향 안 줌
console.log(fruits.slice(1, 3)); // 1부터 3 전까지  추출~
console.log(fruits.slice(1)) 

// 배열의 원소는 어떠한 타입이어도 가능
var arr = [10, 3.14, 'hello', null, undefined, function(a, b){return a + b;}]  // 이렇게 함수가 배열의 원소 타입으로 들어갈 수도 있따!!

// 배열의 원소가 배열일 수도 있다!! -> 다차원 배열 
arr = [[10, 20], [30, 40], [50, 60]]
// arr.length --> ? 3

// TODO
// for 문 사용하여 출력
for(i = 0; i < arr.length; i++){

    for(j = 0; j < 2; j++){
        console.log(arr[i][j]);

    }

}

for(i = 0; i < arr.length; i++){
    console.log(arr[i].toString())
}









console.log('\n프로그램 종료\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n');


