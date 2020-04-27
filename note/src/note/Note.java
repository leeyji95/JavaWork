package note;

public class Note {
/* <url 필기 >
 * 시작태그와 끝태그  사이 -> content”
element(시작태그 + 끝태그 + 컨텐트) 한 덩어리를 말함.

 element 안에 element 들어갈 수 있다. 

<!doctype html>
→ HTML 5 버전이라는 말
body  브라우저에서 직접 보여지는 영역
head 부가적인 정보를 알려주는 영역

엘리먼트 안에 엘리먼트 -> 부모 자식관계로 보아도 된다. 
엘리먼트가 계층구조를 가지고 웹문서를 구성함.

 <input type="text">  
단독 태그로 쓰이는 엘리먼트도 존재한다.

웹크롤링 -> 계층 구조를 찾음

attribute : 시작태그에 들어가는 부가적인 정보.
이름과 value 의 쌍으로 구성되어 있음.
 name=”value” 
<a href="https://www.w3schools.com">This is a link</a>

특정 엘리먼트 찾아가기위한 , 식별할 수 있는 수단으로서 id, class, name 3가지 attribute 가 있다.  

HTML 
CSS
JavaScript

어떤 엘리먼트에 적용할까요? → 여기 구성하는 구문, # -> ___ 이름을 가진 id 에 스타일 적용해라.
이러한 CSS 구문을 CSS 의 Selector 문법이라고 함.   

무슨 스타일로 적용할까요?

Class 는 쩜으로. cites 라는  클래스를 가지고 있는 엘리먼트 찾아가서 적용하세요.
<div class="cities city">  → 띄어쓰기로 클래스 개수 구분

name 은 서버쪽에 데이터 넘길 때 동작
검색어 입력해서 엔터칠 떄, 검색어가 name 에 담겨서 서버에 넘겨짐(바로 아래와 같은 형식으로!)
 http://news.khan.co.kr/kh_news/khan_art_view.html?artid=202003310920001&code=910402&nv=stand&utm_source=naver&utm_medium=newsstand&utm_campaign=top

 http://news.khan.co.kr/kh_news/
 
khan_art_view.html(이 문서에 파라메타가 넘어가고, 파라메타를 담아서 request 요청)

(query String,  파라메타)  ->  url 에 직접 담겨서 request 요청하는 방식이 GET 방식!!
?
artid=202003310920001&
code=910402&
nv=stand&
utm_source=naver&
utm_medium=newsstand&
utm_campaign=top

이게 
name="value" 쌍.   



https://comic.naver.com/webtoon/detail.nhn

?
titleId=20853&
no=1218&
weekday=tue


GET 방식의 장점 : 북마크가 된다. 즐겨찾기. 단점 : 파라메타 한정되어 있음.  
파일 업로딩 같은 거 안됨. 게시판에 글 올리고 이미지 무한정 올릴 수 없다. 
보안성 없다. 

<-> POST 방식 

POST requests are never cached  -> 캐시되지 않음. 기억이 안됨.
POST requests do not remain in the browser history-> 남지 않음. 
POST requests cannot be bookmarked ->  북마크가 되지 않음(쿼리방식이 아니므로)
POST requests have no restrictions on data length(제한 없다.  GET 방식이랑 반대니까? )


url 에는 한글, 띄어쓰기 안됨
https://comic.naver.com/search.nhn?keyword=%EB%85%B8%EA%B3%A4%ED%95%98%EA%B0%9C(내가 한글 입력한 거는 이런식으로 나옴. url encoding 하고 url에 작성하여야 함.
 16진수 2자리 -> 1바이트 이므로, 지금 총 12바이트  그러면 "노곤하개" 니까 한글 한글자당 3바이트 란 소리. 
결론, 한글은 url-encoding 해야한다! 라는 말.

 */
	
	
	/*
 CSS Selectors
p {
  text-align: center;
  color: red;
}

--> <p> element 
특정 엘리먼트에 적용하고싶으면 -> 태그 이름  으로 

---------------------------------------------------------------------------------------------------------
#para1 {
  text-align: center;
  color: red;
} 
id 가 para1 인 엘리먼트 적용 -> #아이디이름  ---> 오직 한 개만! 적용!

--------------------------------------------------------------------------------------------------------

.center {
  text-align: center;
  color: red;
}
center 라는 클래스를 가지고 있는 엘리먼트 들**에 적용!   --> 여러개 적용할 수 있따는 것!

--------------------------------------------------------------------------------------------------------

p.center {
  text-align: center;
  color: red;
}
-> center 클래스 가지고 있는 특정 p 엘리먼트에 적용 

--------------------------------------------------------------------------------------------------------
p.center.large{
}   
-> center 와 large 두 개의 클래스 모두 가지고 있는 p 엘리먼트에 적용해라.   "복수개의 클래스를 가지고 있는 특정 엘리먼트"

--------------------------------------------------------------------------------------------------------

h1, h2, p {
  text-align: center;
  color: red;
}

셀렉터들을 콤마로 나열 -> 동일하게 적용됨.

===========================================================
There are four different combinators in CSS:

1. descendant selector (space)  : 
div p {
  background-color: yellow;
}
div 의 자손인 p 엘리먼트 

--------------------------------------------------------------------------------------------------------
2. child selector (>)
div 의 바로 직계 자식만 선택

--------------------------------------------------------------------------------------------------------
3. adjacent sibling selector (+)  _인접한 형제 셀렉터

<body>

   <div>
      <p>Paragraph 1 in the div.</p>
      <p>Paragraph 2 in the div.</p>
   </div>

   <p>Paragraph 3. Not in a div.</p>  ---- div 의 첫번째 형제 (가까운 형제가 택)
   <p>Paragraph 4. Not in a div.</p> ---- div 의 두번째 형제

</body>

---->  div 다음에 나오는 인접한 형제 p 엘리먼트를 선택함

--------------------------------------------------------------------------------------------------------
4. general sibling selector (~)

div의 모~든 형제들 중 p 엘리먼트를 말함(여기서 모든 형제들은  div 다음에 나오는 형제들을 말하는 것임 )
*/
	
	
	/*
	 ======================================================================================================================
<pseudo-classes> - 어떤 엘리먼트의 특정 상태를 표현


 mouse over link 
a:hover {         // 마우스를 올려 놓은 상태.
  color: hotpink;
}

/selected link 
a:active {   // 마우스를 눌렀을 떄 -> 를 active 상태.
  color: blue;
}


 visited link 
a:visited {     // 한번이라도 방문했다면 초록색상태.
  color: green;
}


슈도 클래스엔 종류가 많음. 그 중 크롤링에서 유용한 것만 보겠다.

:first-child 의미   p:first-child   Selects every <p> elements that is the first child of its parent
맏아들인 p 엘리먼트가 선택이 된다.

<!DOCTYPE html>
<html>
<head>
<style>
p:first-child {
  background-color: yellow;
}
</style>
</head>
<body>

<p>This paragraph is the first child of its parent (body).</p>(선택)

<h1>Welcome to My Homepage</h1>
<p>This paragraph is not the first child of its parent.</p>

<div>
  <p>This paragraph is the first child of its parent (div).</p>(선택)
  <p>This paragraph is not the first child of its parent.</p>
</div>

<p><b>Note:</b> For :first-child to work in IE8 and earlier, a DOCTYPE must be declared.</p>

</body>
</html>





:nth-child(n)	p:nth-child(2)	Selects every <p> element that is the second child of its parent
n번째 자식 엘리먼트 선택된다. 


<!DOCTYPE html>
<html>
<head>
<style> 
p:nth-child(2) {    (even) (odd) 짝수번째 엘리먼트, 홀수 엘리먼트 선택됨
  background: red;
}
</style>
</head>
  <body>

    <p>The first paragraph.</p>
    <p>The second paragraph.</p>
    <p>The third paragraph.</p>
    <p>The fourth paragraph.</p>

    <p><b>Note:</b> Internet Explorer 8 and earlier versions do not support the :nth-child() selector.</p>

  </body>
</html>



Pseudo-Elements( :: )
<!DOCTYPE html>
<html>
<head>
<style>
p::first-line {        // 첫번째 줄 적용
  color: #ff0000;
  font-variant: small-caps;
}
</style>
</head>
<body>

<p>You can use the ::first-line pseudo-element to add a special effect to the first line of a text. Some more text. And even more, and more, and more, and more, and more, and more, and more, and more, and more, and more, and more, and more.</p>

</body>
</html>





CSS [attribute] Selector   특정 엘리먼트를 가지고 있는 셀렉터 


a[target] {
  background-color: yellow;
}
a 엘리먼트 중에서도 taget 이라는 attribute 가 있는 엘리먼트를 적용시키겠다. 


<!DOCTYPE html>
<html>
<head>
<style>
a[target] {
  background-color: yellow;
}
</style>
</head>
  <body>

    <p>The links with a target attribute gets a yellow background:</p>

    <a href="https://www.w3schools.com">w3schools.com</a>
    <a href="http://www.disney.com" target="_blank">disney.com</a>  (적용)
    <a href="http://www.wikipedia.org" target="_top">wikipedia.org</a> (적용)

    <p><b>Note:</b> For [<i>attribute</i>] to work in IE8 and earlier, a DOCTYPE must be declared.</p>

  </body>
</html>





a[target="_blank"] {
  background-color: yellow;
}




CSS [attribute~="value"] Selector  "포함하고 있는가?"

<!DOCTYPE html>
<html>
<head>
<style>
[title~=flower] {
  border: 5px solid yellow;
}
</style>
</head>
<body>

<p>All images with the title attribute containing the word "flower" get a yellow border.</p>

<img src="klematis.jpg" title="klematis flower" width="150" height="113">
<img src="img_flwr.gif" title="flower" width="224" height="162">
<img src="img_tree.gif" title="tree" width="200" height="358">

</body>
</html>


---> flower 를 포함하고 있는 attribute




CSS [attribute|="value"] Selector
CSS [attribute^="value"] Selector
둘 다 시작이 value 여야 함. 

[class|=top] {
  background: yellow;
}  
class 라는 attribute가 top 으로 온전한 단어로 시작할 떄
공백이거나 - 으로 띄어져 있는 경우, 


name 가지고 크롤링 하는 경우는 많지 않으나, 어쩔 수 없이 해야할 경우 attribute 방법으로 크롤링 해야 한다. 



===========================================


표준 doc으로 메모리에 저장..
DOM 
헤드랑 바디 엘리먼트는 html 의 새끼.
각각을 node 라고 함. 
엘리먼트의 node 들이 계층구조를 이루며 내려감. 

Text 도 Eelement 노드의 child 이다.

계층적인 구조로 저장이 된다. 

단, Attribute 는 별도. 노드의 자식이 아님. 부속으로 봄.

자바스크립트 공부하면 DOM 다시 공부.

==================================

	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
