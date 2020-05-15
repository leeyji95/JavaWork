const dog = {
    name : "멍멍이", 
    sound : "멍멍!", 


    // 객체 안에 함수 정의하는 다양한 방법들

    // 방법1 
    say1 : function aaa(){
        console.log(this.sound) ;   // this 는 함수가 위치한(소유한) 객체     
        // say1 에 함수를 대입한 거다
    },

       // 방법2 : 이름없는 함수(추천)
       say2 : function() {
        console.log(this.sound);
    }, 

        // 방법3 : 최신 JS 방식 (추천)
     say3() {
        console.log(this.sound);
    },

    /// 화살표 함수의 경우..  => this 가 문제된다.
    say4 : () => {
        console.log(this.sound);
        console.log(this);
    }, 

    // 이유
    // function 키워드로 만든 함수에서의 this는
  // 자기가 속해있는, 객체를 가리키는데..
  // 화살표 함수의 경우
  // this를 자기가 속해 있는 곳으로
  // 연결하지 않습니다.
  // 화살표 함수는 this 가 뭔지 모릅니다!

}
dog.say1();
//dog.aaa();
dog.say2();
dog.say3();
dog.say4();




const cat = {
    name : "야옹이",
    sound : "냐아~"
}
cat.say1 = dog.say1;  // dog.say1 은 함수 
dog.say1();
cat.say1(); // 이 경우는 this가 cat이다.
 // 이때 thois 는 cat이 된다. 

 const sayCat = cat.say1();
 console.log(typeof sayCat);  // function 
 sayCat(); // this에 아무것도 '연결'되지 않는다.  !  this 는 undefined 






