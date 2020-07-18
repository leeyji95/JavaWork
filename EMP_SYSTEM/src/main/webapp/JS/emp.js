$(document).ready(function(){
	
	// 게시판 목록 1 페이지 로딩 
	loadPage(page);
	
	// 등록 작성 버튼 누르면 모달 팝업 뜨기 
	$("#btnWrite").click(function(){
		setPopup("write"); 
		$("#dlg_write").show();
	});
	
	// 모달 대화상자에서 close 버튼 누르면 닫기
	$(".modal .close") .click(function(){
		$(this).parents(".modal").hide(); 
		
	});
	
	$("#frmWrite").submit(function(){
		$(this).parents(".modal").hide();
		return chkWrite();
	});
	
	
	// 삭제 버튼 누르면 
	$("#btnDel").click(function(){
		chkDelete();
	});
	
	//  읽기(view) 대화상자에서 수정버튼 누르면 
	$("#viewUpdate").click(function(){
		setPopup("update");
	});
	
	// 수정완료 버튼 누르면 
	$("#updateOk").click(function(){
		chkUpdate();
	});
	
	
});


// 페이지 로딩 
function loadPage(page){
	
	$.ajax({
		url : "list.ajax"
		, type : "get"
		, cache : false
		, success : function(data, status){
			if(status == "success"){
				
				//alert("AJAX 성공 : request 성공"); // 최초 로딩 시 뜸 
				if(updateList(data)){
					
					// 업데이트된 list 에 필요한 이벤트 가동
					addViewEvent();
					// ★만약 위 코드를 $(document).ready() 에 두면 동작 안할 것이다. 
					// 뭐가 완료된 시점에서 뭐가 실행되어야 하는지 정확히 알아야 함. =======>   //클릭하는 리스너는 페이지 로딩이 끝난 시점에 동작하도록 해야 실행된다. 
				} // end if
			}
		}
	});
	
} // end loadPage()



function updateList(jsonObj){
	
	result = "";  
	
	if(jsonObj.status == "OK"){
		
		var count = jsonObj.count;
		
		var i;
		var items = jsonObj.data; // 배열
		for(i = 0; i < count; i++){
			// result 문자열 조립할 거고, 포문 다끝나면 
			result += "<tr>\n";
			result += "<td>" + items[i].num + "</td>\n";
			result += "<td>" + items[i].dept + "</td>\n"; 
			result += "<td>" + items[i].name + "</td>\n";
			result += "<td>" + items[i].tel + "</td>\n"; 
			result += "<td>" + items[i].email + "</td>\n";
			result += "</tr>\n";
		} // end for
		$("#list tbody").html(result); // 테이블 업데이트 ! 
		
		return true;
	} else{
		alert(jsonObj.message);
		return false;
	}
	return false;
} // end updateList




//새 글 등록 처리
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
	
	return false;  // 페이지 리도딩은 안 할 것이다.
} // end chkWrite()
function setPopup(mode){
	
	// 등록
	if(mode == 'write'){
		$('#frmWrite')[0].reset();  // $('#frmWrite') 엘리먼트 집합들의 object 를 리턴하므로, 반드시 0 번째 라고 명시한 다음 reset() 을 써야한다. reset 은 jquery 함수 아니고, js 함수이다
		// -> form 안의 기존 내용 reset
		$('#dlg_write .title').text("새글작성");
		$('#dlg_write .btn_group_header').hide();
		$('#dlg_write .btn_group_write').show();
		$('#dlg_write .btn_group_view').hide();
		$('#dlg_write .btn_group_update').hide();
		
		$("#dlg_write input[name='subject']").attr("readonly", false);
		$("#dlg_write input[name='subject']").css("border", "1px solid #ccc");

		$("#dlg_write input[name='name']").attr("readonly", false);
		$("#dlg_write input[name='name']").css("border", "1px solid #ccc");

		$("#dlg_write textarea[name='content']").attr("readonly", false);
		$("#dlg_write textarea[name='content']").css("border", "1px solid #ccc");
	}
	
	// 읽기
	if(mode == 'view'){
		$('#dlg_write .title').text("둥록보기");
		$('#dlg_write .btn_group_header').show();
		$('#dlg_write .btn_group_write').hide();
		$('#dlg_write .btn_group_view').show();
		$('#dlg_write .btn_group_update').hide();
		
		$("#dlg_write input[name='uid']").val(viewItem.uid);  // 나중에 삭제/수정을 위해 필요
		
		$("#dlg_write input[name='subject']").val(viewItem.subject);
		$("#dlg_write input[name='subject']").attr("readonly", true);
		$("#dlg_write input[name='subject']").css("border", "none");

		$("#dlg_write input[name='name']").val(viewItem.name);
		$("#dlg_write input[name='name']").attr("readonly", true);
		$("#dlg_write input[name='name']").css("border", "none");

		$("#dlg_write textarea[name='content']").val(viewItem.content);
		$("#dlg_write textarea[name='content']").attr("readonly", true);
		$("#dlg_write textarea[name='content']").css("border", "none");
	}

	// 수정
	if(mode == 'update'){
		$('#dlg_write .title').text("글 수정");
		$('#dlg_write .btn_group_header').show();
		$('#dlg_write .btn_group_write').hide();
		$('#dlg_write .btn_group_view').hide();
		$('#dlg_write .btn_group_update').show();
		
		$("#dlg_write input[name='subject']").attr("readonly", false);
		$("#dlg_write input[name='subject']").css("border", "1px solid #ccc");

		$("#dlg_write input[name='name']").attr("readonly", true);  // 이름은 수정 불가능 하도록  설정 

		$("#dlg_write textarea[name='content']").attr("readonly", false);
		$("#dlg_write textarea[name='content']").css("border", "1px solid #ccc");
	}
	
} // end setPopup()

	// 글 수정 
	function chkUpdate(){
		
		var data = $("#frmWrite").serialize();
		$.ajax({
			url: "updateOk.ajax",
			type: "post",
			cache: false,
			data : data,
			success: function(data, status){
				if(status == "success"){
					if(data.status == "OK"){
						alert("UPDATE 성공" + data.count + "개:" + data.status);
						// 성공한 경우 현재 페이지 리로딩
						loadPage(window.page);  
					} else{
						alert("UPDATE 실패" + data.status + " : " + data.message);
						
					}
					$("#dlg_write").hide();  //현재 팝업 닫기.
				}
			}
		});
		
	} // end chkUpdate
