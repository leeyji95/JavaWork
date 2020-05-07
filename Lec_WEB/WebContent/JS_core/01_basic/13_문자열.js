var str1, str2, str3;

str1 = "John"
str2 = new String("John"); // 비추

console.log(str1)
console.log(str2.toString())

console.log(str1 == str2)
console.log(str1 === str2)


console.log(str1.length); // 문자의 개수 

str2 = "Hello Java Web FrameWork";
console.log(str2);

// 문자열 리터럴 중간을 끊어서 작성할 경우...(부득이하게 끊어서 작성해야 할 떄..)
str2 = "Hello Java W\
eb FrameWork";
console.log(str2);


// indexOf(), lastIndexOf(), search() : 문자열 안에서 문자열 찾기
// 찾은 위치 인덱스 리턴, 못찾으면 -1 리턴
console.log("문자열 검색 \nindexOf(), lastIndexOf(), search()");
str1 = "Please locate where 'locate' occurs!";
console.log(str1.indexOf("locate")) // 7번째 발견하므로  7 출력
console.log(str1.lastIndexOf("locate")) // 마지막으로 발견된 locate 의 위치 인덱스번호를 리턴함. 


console.log(str1.indexOf("John"))   // 발견 못하면 -1 리턴
console.log(str1.indexOf("locate", 10))  // 10 번째부터 검색 시작하여 locate 를 찾음. 
console.log(str1.indexOf("locate", 25))   // -1  리턴

// search() : 문자열 안에서 문자열 찾기
console.log(str1.search("locate"))  // 7
// search() vs indexOf() : 둘은 다르다!
// 	search() : 두번째 매개변수 없다  =>  몇 번째부터 찾겠다 이런거 없다.
// 	indexOf() : regexp 사용 불가

// 배열은 주로 찾거나 치환 으로 사용



console.log()
//문자열 추출
//slice(start, end)
//substring(start, end)
//substr(start, length)
console.log("문자열 추출\nslice(), substring(), substr()");
str1 = "Apple, Banana, Kiwi";

console.log(str1.slice(7, 13)); // 7부터 13전 까지 
console.log(str1.slice(-12, -6)); // -12 부터 -6 전까지  // 음수 인덱싱 가능
console.log(str1.slice(7)); // 7부터 끝까지
console.log(str1.slice(-12)); // -12 부터 끝까지 

console.log(str1.substring(7, 13));  // slice() 와 유사하나 음수인덱싱 지원 안함.
console.log(str1.substring(7)); // 7부터 끝까지 

console.log(str1.substr(7, 6)); // 7부터 6글자
console.log(str1.substr(7)); // 7부터 끝까지 





console.log()
// 문자열 치환
// replace() : 치환한 결과 문자열 리턴, 정규표현식 사용 가능
// 기본적으로 첫번째 '매칭된 문자열 만 치환
console.log("문자열 치환 replace()");
str1 = "Please visit Japan!";
console.log(str1.replace("Japan", "Korea"));  // 원본 str1 변경안함..!!!
console.log(str1.replace("JAPAN", "Korea"));
console.log(str1.replace(/JAPAN/i, "Korea")); // 정규표현식 대소문자 구분없이 치환 한다! ( 뒤에 저 'i ' 붙여야함)


str2 = "Please visit Japan! Go Japan...";
console.log(str2.replace("Japan", "Korea")); // 기본적으로 첫번째만 치환됨.
console.log(str2.replace(/Japan/g, "Korea")) // 정규표현식, global match


str3 = "Hello World";
console.log(str3.toUpperCase())
console.log(str3.toLocaleLowerCase())


str1 = "Hello"; str2 = "World";
console.log(str1 + " " + str2)
console.log(str1.concat(" ", str2))

// trim() : 좌우 공백 제거 ( 웹에서 무지 많이 사용)
str1 = "            Hello World     ";
console.log(`str1 = [${str1}]`)
str2 = str1.trim();
console.log(str2)
console.log(`str2 = [${str2}]`)


// split() : string -> array
str3 = '2020-05-07';
console.log(str3.split('-'))


