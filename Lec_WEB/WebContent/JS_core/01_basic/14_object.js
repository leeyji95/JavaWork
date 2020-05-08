// object
console.log('object');

// property:value 쌍
x = {firstName: "John", lastName: "Doe"};
console.log(x, typeof x)

// value 접근하는 방법 
console.log(x['firstName'], x.firstName);
// console.log(x[firstName]); // X    x 의 변수값으로 인식하므로 undefined 나옴. 

// object 는 length 값 없다.
console.log(x.length);


// for ~ in 
for(key in x){ // property 가 추출됨.  (string)
    console.log(`x[${key}] = ${x[key]}`);
}


// value 는 어떠한 타입이라도 가능!
x = {
    name : "kim"
    , age : 34
    , height : 172.3
    , score : [94, 35, 79]
    , sayHello : function(){
        console.log('안녕하세요');
    }
    , getScore : function(n){
        // return score[n];  // this 빼면 에러!!  동일 object내 property 접근할때 this 사용!
        return this.score[n];
    }
    , getTotal : function(){
        var sum = 0;
        for(i = 0; i < this.score.length; i++){
            sum += this.score[i];
        }
        return sum;
    }
    , getAvg : function(){
        var avg = this.getTotal() / this.score.length;
        return avg.toFixed(2); // 소수점 2자리까지. 
    }
};

console.log(x['name'], typeof x['name']);
console.log(x['age'], typeof x['age']);
console.log(x.height, typeof x.height);
console.log(x.score, x.score.length, "개");
x.sayHello();
console.log(x.getScore(0));
console.log(x.getTotal()); // score 점수 합계
console.log(x.getAvg()); // score 점수 평균
console.log(x["getAvg"]());

/* 
ReferenceError: score is not defined
같은 class 안에 있는 얘 인데, 접근못한다. 그래서 에러.
접근하려면 반드시 this 사용!
*/


console.log();

// p:v 추가 / 삭제 / 변경
x = {firstName: "John", lastName: "Doe"};
console.log(x);
x.firstName = "Mike" // 변경
console.log(x);

x['age'] = 45;  // 없던 property 추가 
console.log(x);

delete x.firstName;
console.log(x);

// 없는 property 접근하려 하면 
console.log(x.firstName); // undefined

//------------------------------------
// console.log(a); //  존재 하지 않음
var b;
console.log(b);  // 존재는 하나, 값이 없음 
b = '김재현';
console.log(b); 
// delete b; // delete 는 원래  오브젝트의 프라퍼티를 제거하는데 사용된다. 
//console.log(b); 


// '함수' 가 'object 생성자' 로 사용 가능하다.
function Person(firstName, lastName, age){
    // 함수 안에서 this! 
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;

    // console.log(this);
} 

Person('aaa', 'bbb', 30); // 호출

var p1 = new Person('aaa', 'bbb', 30)  ; // 생성자 로 동작한다!   new 다음 함수호출..하면 이케 된다.
console.log(p1);

// 함수자체가 자바에서의 클래스 객체로 정의된다. 
// 함수 안에서 this 사용해서 오브젝트의 프라퍼티, 즉 멤버변수가 된다.
var p2 = new Person('김', '재현', 25);
console.log(p2);


// 핵심정리 : JS 에서는 생성자 역할 하는 함수를 만들어서 오브젝트 정의한다.
















console.log('\n프로그램종료\n\n\n\n\n\n\n\n\n\n\n\n\n\n');



