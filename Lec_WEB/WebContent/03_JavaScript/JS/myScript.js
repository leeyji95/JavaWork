/**
 * TODO
 */

 function light(sw){
     var pic;  // ES5 버전으로 배울 거기 떄문에 let, const 되도록 안쓰겠다.. 
     if(sw == 0){
        pic = "https://www.w3schools.com/html/pic_bulboff.gif";
     } else{
        pic = "https://www.w3schools.com/html/pic_bulbon.gif";
     }
     // <img> 의 src 값 변경 
     document.getElementById('myImage').src = pic;  
 }
 

 // 별도의 JS 파일에다가 함수를 만들었고, 이 외부파일을 html에서 불러오자
 
 
