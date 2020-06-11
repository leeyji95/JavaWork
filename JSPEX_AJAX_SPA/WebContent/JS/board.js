var page = 1 // 현재 페이지
var pageRows = 10 // 한 페이지에 보여지는 게시글 개수


$(document).ready(function(){
	
	// 게시판 목록 1 페이지 로딩 
	loadPage(page);
	
	// 글 작성 버튼 누르면 모달 팝업 뜨기 
	$("#btnWrite").click(function(){
		$("#dlg_write").show();
	});
	
	// 모달 대화상자에서 close 버튼 누르면 닫기
	$(".modal .close").click(function(){
		$(this).parents(".modal").hide();  // this가 클로즈  엑스. parents 는 부모를 찾아가는데, modal 이라는 클래슬를 가지고 있는 부모까지 찾아 올라간다. (매개변수가 있는애가 있고, 아닌애가 있다.)
		
	});
	
	// ★★★  글 작성 submit 되면 처리(여기서 백그라운드 request 보내줘야함)
	$("#frmWrite").submit(function(){
		$(this).parents(".modal").hide();
		return chkWrite();
	});
	
	// form 에 action 주지 않고 submit 하면 자기 페이지로 request 보내어 리로딩됨
	// 그래서 이 chkWrite () 를   false 처리 해야함.
	
	
	// 글 삭제 버튼 누르면 
	$("#btnDel").click(function(){
		chkDelete();
	});
	
	
	
});

// page 번째 페이지 로딩 
function loadPage(page){
	
	$.ajax({
		url : "list.ajax?page=" + page + "&pageRows=" + pageRows
		, type : "get"
		, cache : false
		, success : function(data, status){
			if(status == "success"){
				
				//alert("AJAX 성공 : request 성공"); // 최초 로딩 시 뜸 
				updateList(data);
			}
		}
	});
	
} // end loadPage()


function updateList(jsonObj){
	
	result = "";  
	
	if(jsonObj.status == "OK"){
		
		var count = jsonObj.count;
		
		// 전역변수를 여기서 업데이트합니다.(분명 내가 서버단에 디폴트로 한 값과 다름)
		// 전역 변수 업데이트 !
		window.page = jsonObj.page;
		window.pageRows = jsonObj.pagerows;
		
		var i;
		var items = jsonObj.data; // 배열
		for(i = 0; i < count; i++){
			// result 문자열 조립할 거고, 포문 다끝나면 
			result += "<tr>\n";
			result += "<td><input type='checkbox' name='uid' value='" + items[i].uid + "'></td>\n";
			result += "<td>" + items[i].uid + "</td>\n";
			result += "<td>" + items[i].subject + "</td>\n";
			result += "<td>" + items[i].name + "</td>\n";
			result += "<td>" + items[i].viewcnt + "</td>\n";
			result += "<td>" + items[i].regdate + "</td>\n";
			result += "</tr>\n";
		} // end for
		$("#list tbody").html(result); // 테이블 업데이트 ! 
		
		// 페이지 정보 업데이트 
		$('#pageinfo').text(jsonObj.page + "/" + jsonObj.totalpage + "페이지, " + jsonObj.totalcnt + "개의 글");
		
		// pageRows
		var txt = "<select id='rows' onchange='changePageRows()'>\n";
		txt += "<option " + ((window.pageRows == 10)?"selected":"") + " value='10'>10개씩</option>\n";
		txt += "<option " + ((window.pageRows == 20)?"selected":"") + " value='20'>20개씩</option>\n";
		txt += "<option " + ((window.pageRows == 50)?"selected":"") + " value='50'>50개씩</option>\n";
		txt += "<option " + ((window.pageRows == 100)?"selected":"") + " value='100'>100개씩</option>\n";		
		txt += "</select>\n";
		$("#pageRows").html(txt);

		// 페이징 업데이트
		var pagination = buildPagination(jsonObj.writepages, jsonObj.totalpage, jsonObj.page, jsonObj.pagerows);
		$("#pagination").html(pagination);
		
		
		return true;
	} else{
		alert(jsonObj.message);
		return false;
	}
	return false;
} // end updateList

function buildPagination(writePages, totalPage, curPage, pageRows){
	
	var str = "";   // 최종적으로 페이징에 나타날 HTML 문자열 <li> 태그로 구성
	
	// 페이징에 보여질 숫자들 (시작숫자 start_page ~ 끝숫자 end_page)
    var start_page = ( (parseInt( (curPage - 1 ) / writePages ) ) * writePages ) + 1;
    var end_page = start_page + writePages - 1;

    if (end_page >= totalPage){
    	end_page = totalPage;
    }
    
  //■ << 표시 여부
	if(curPage > 1){
		str += "<li><a class='tooltip-top' title='처음'><i class='fas fa-angle-double-left'></i></a></li>\n";
	}
	
  	//■  < 표시 여부
    if (start_page > 1) 
    	str += "<li><a onclick='loadPage(" + (start_page - 1) + ")' class='tooltip-top' title='이전'><i class='fas fa-angle-left'></i></a></li>\n";
    
    //■  페이징 안의 '숫자' 표시	
	if (totalPage > 1) {
	    for (var k = start_page; k <= end_page; k++) {
	        if (curPage != k)
	            str += "<li><a onclick='loadPage(" + k + ")'>" + k + "</a></li>\n";  // k번째 페이지로 이동
	        else
	            str += "<li><a class='active tooltip-top' title='현재페이지'>" + k + "</a></li>\n";
	    }
	}
	
	//■ > 표시
    if (totalPage > end_page){
    	str += "<li><a onclick='loadPage(" + (end_page + 1) + ")' class='tooltip-top' title='다음'><i class='fas fa-angle-right'></i></a></li>\n";
    }

	//■ >> 표시
    if (curPage < totalPage) {
        str += "<li><a onclick='loadPage(" + totalPage + ")' class='tooltip-top' title='맨끝'><i class='fas fa-angle-double-right'></i></a></li>\n";
    }

    return str;


	
} // end buildPagination()


function changePageRows(){
	window.pageRows = $("#rows").val(); 
	loadPage(window.page);
}


// 새 글 등록 처리
function chkWrite(){
	
	var data = $("#frmWrite").serialize(); // form 의 모든 name 들을 다 끌고 들어옴. 
				// name=aaa&subject=bbb&content=ccc
	//alert(data + "--" + typeof data); // 리턴 Object 임. 
	// ajax request 
	$.ajax({
		url : "writeOk.ajax",
		type : "post",
		cache : false,
		data : data, // POST 로 ajax request 하는 경우  parameter 담기 
		success : function(data, status){
			if(status == "success"){ // 여기서의 success 는 코드 200
				if(data.status == "OK"){ // 정상적으로 insert 되었다는 의미
					loadPage(1);  // 첫페이지 리로딩 되도록
					alert("INSERT 성공" + data.count + "개:" + data.status);
				} else{
					alert("INSERT 실패" + data.status + " : " + data.message);
				}
			}
		}
		
	});
	// request 후, form 에 입력된 것 reset()
	$('#frmWrite')[0].reset();  // 특정 object 만 reset 하는 애이다. 
	// 제이쿼리 는 여러개의 오브젝트를 반환한다. 그래서  제이쿼리 셀렉터에서 특정 애 하나 꺼내어서 reset 해줘야한다.
	
	return false;  // 페이지 리도딩은 안 할 것이다.
} // end chkWrite()


// check 된 uid 의 게시글들만 삭제하기
function chkDelete(){
	var uids = []; // 빈 배열 준비 
	$("#list tbody input[name=uid]").each(function(){  // 각각에 대해 이 함수 수행하겠다.
		// $(this) //각각 name이 uid인 checkbox 
		if($(this).is(":checked")){  // jQuery 에서 check 여부 확인방법 
			uids.push($(this).val()); // 배열에 uid 값 추가 
		}
	});
	
	//alert(uids); 확인용
	
	// 검증하기 _ 하나라도 체크 안되어 있다면
	if(uids.length == 0){
		alert('삭제할 글을 체크해주세요');
	} else{
		if(!confirm(uids.length + "개의 글을 삭제하시겠습니까?")) return false; // 아니오 선택시 false 리턴하도록.
		
		var data = $("#frmList").serialize();
		//  uid=1919&uid=1010&uid=8888
		
		$.ajax({
			url : "deleteOk.ajax",
			type : "post",
			data : data,
			cache : false,
			success : function(data, status){
				// DML 수행시 count, status 결과로 받음
				if(status == "success"){
					if(data.status == "OK"){
						alert("DELETE 성공" + data.count + "개");
						// 현재 페이지 리로딩
						loadPage(window.page);
					}else{
						alert("DELETE 실패" + data.message);
					}
				}
			}
		});
	}
	
	
} // end chkDelete()
















