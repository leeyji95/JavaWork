$(document).ready(function() {

	loadPage();

});

// 첫 페이지 로딩 시 -> depth = 1 request 요청
function loadPage() {

	$.ajax({
		url : "cate_list.ajax?depth=1",
		type : "post",
		cache : false,
		success : function(data, status) {
			if (status == "success") {
				updateList1(data);
			}
		}
	});
} // end loadPage()

// depth = 1 인 name 들 가져와서 보여주기
function updateList1(jsonObj) {

	result = "";

	if (jsonObj.status == "OK") {

		var count = jsonObj.count;

		var i;
		var items = jsonObj.list; // 배열
		result += "<option selected>" + "--선택하세요--" + "</option>\n";
		for (i = 0; i < count; i++) {
			result += "<option value='" + items[i].uid + "'>";
			result += items[i].name;
			result += "</option>\n";
			
//			$('#depth1').on('change', function() {
////			  alert( this.value );
//				if($("#depth1 option:selected").val() == 1){
//					depth1(1);
//				}else if ($("#depth1 option:selected").val() == 2){
//					depth2(2);
//				} else if($("#depth1 option:selected").val() == 3){
//					depth3(3);
//				} 
//			});
			
			$('#depth1').on('change', function() {
//				  alert( this.value );
				if($("#depth1 option:selected").val() == this.value){
					second(this.value);
				}
		});
		} // end for
		$('#depth1').html(result);
		$('#depth1').removeAttr("disabled");
		
		
		return true;
	} else {
		alert(data.message);
		return false;
	}
	return false;
} // end updateList



function second(parent){
	
	$.ajax({
		url : "cate_list.ajax?depth=2&parent=" + parent,
		type : "post",
		cache: false,
		success: function(data, status){
			console.log("두번쨰 카테고리!!!");
			if(status == "success"){
				updateList2(data);
			}
		}
	});
}

function updateList2(jsonObj) {
	result = "";

	if (jsonObj.status == "OK") {

		var count = jsonObj.count;
		console.log("count: " + count);
		
		var i;
		var items = jsonObj.list; // 배열
		result += "<option selected>" + "--선택하세요--" + "</option>\n";
		for (i = 0; i < count; i++) {
			result += "<option value='" + items[i].uid + "'>";
			result += items[i].name;
			result += "</option>\n"
				
			$('#depth2').on('change', function() {
//					  alert( this.value );
					if($("#depth2 option:selected").val() == this.value){
						third(this.value);
					}
			});

		} // end for
		$('#depth2').html(result);
		$('#depth2').removeAttr("disabled");

		return true;
	} else {
		alert(jsonObj.message);
		return false;
	}
	return false;
}

function third(parent){
	$.ajax({
		url : "cate_list.ajax?depth=3&parent=" + parent,
		type : "post",
		cache: false,
		success: function(data, status){
			console.log("3번째 카테고리다!!");
			if(status == "success"){
				lastUpdate(data);
			}
		}
	});
}


function lastUpdate(jsonObj){
	result = "";

	if (jsonObj.status == "OK") {

		var count = jsonObj.count;
		console.log("count: " + count);
		
		var i;
		var items = jsonObj.list; // 배열
		result += "<option selected>" + "--선택하세요--" + "</option>\n";
		for (i = 0; i < count; i++) {
			result += "<option value='" + items[i].uid + "'>";
			result += items[i].name;
			result += "</option>\n"

		} // end for
		$('#depth3').removeAttr("disabled");
		$('#depth3').html(result);

		return true;
	} else {
		alert(jsonObj.message);
		return false;
	}
	return false;
}

//
//function depth2(parent){
//	
//	$.ajax({
//		url : "cate_list.ajax?depth=2&parent=" + parent,
//		type : "post",
//		cache: false,
//		success: function(data, status){
//			console.log("제발 찍혀라2222!!!");
//			if(status == "success"){
//				
//				updateList2(data);
//			}
//		}
//	});
//}
//
//
//
//function updateList2(jsonObj) {
//	result = "";
//
//	if (jsonObj.status == "OK") {
//
//		var count = jsonObj.count;
//		console.log("count: " + count);
//		
//		var i;
//		var items = jsonObj.list; // 배열
//		result += "<option selected>" + "--선택하세요--" + "</option>\n";
//		for (i = 0; i < count; i++) {
//			result += "<option value='" + items[i].uid + "'>";
//			result += items[i].name;
//			result += "</option>\n"
//
//		} // end for
//		$('#depth2').removeAttr("disabled");
//		$('#depth2').html(result);
//
//		return true;
//	} else {
//		alert(jsonObj.message);
//		return false;
//	}
//	return false;
//}
//
//function depth3(parent){
//	
//	$.ajax({
//		url : "cate_list.ajax?depth=2&parent=" + parent,
//		type : "post",
//		cache: false,
//		success: function(data, status){
//			console.log("제발 찍혀라333!!!");
//			if(status == "success"){
//				updateList3(data);
//			}
//		}
//	});
//}
//
//function updateList3(jsonObj) {
//	result = "";
//
//	if (jsonObj.status == "OK") {
//
//		var count = jsonObj.count;
//		console.log("count: " + count);
//		
//		var i;
//		var items = jsonObj.list; // 배열
//		result += "<option selected>" + "--선택하세요--" + "</option>\n";
//		for (i = 0; i < count; i++) {
//			result += "<option value='" + items[i].uid + "'>";
//			result += items[i].name;
//			result += "</option>\n"
//
//		} // end for
//		$('#depth2').removeAttr("disabled");
//		$('#depth2').html(result);
//
//		return true;
//	} else {
//		alert(jsonObj.message);
//		return false;
//	}
//	return false;
//}





