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
				depth1Update(data);
			}
		}
	});
	
} // end loadPage()

// depth = 1 인 name 들 가져와서 보여주기
function depth1Update(jsonObj) {

	result = "";

	if (jsonObj.status == "OK") {

		var count = jsonObj.count;

		var i;
		var items = jsonObj.list; // 배열
		result += "<option value='0'>" + "--선택하세요--" + "</option>\n";
		for (i = 0; i < count; i++) {
			result += "<option value='" + items[i].uid + "'>";
			result += items[i].name;
			result += "</option>\n";
			  
		} // end for
		$('#mycate select:first').html(result);
		$('#mycate select:first').removeAttr("disabled");

		$('#mycate select:first').on('change', function() {
//			 alert( this.value ); // selected 된 uid 값
			var select = $("#mycate select:first option:selected").val();
			if (select == this.value) { 
				if(select == 0) {
					$('#mycate select:odd').attr("disabled", true);
					$('#mycate select:odd').html("");
					$('#mycate select:last').attr("disabled", true);
					$('#mycate select:last').html("");
				} else{
					loadPage2(select);
				}
			} 
		});
		
		return true;
	} else {
//		alert(data.message);
		return false;
	}
	return false;
} // end updateList

function loadPage2(parent) {

	$.ajax({
		url : "cate_list.ajax?depth=2&parent=" + parent,
		type : "post",
		cache : false,
		success : function(data, status) {
			console.log("두번쨰 카테고리!!!");
			if (status == "success") {
				depth2Update(data);
			}
		}
	});
}

function depth2Update(jsonObj) {
	result = "";

	if (jsonObj.status == "OK") {

		var count = jsonObj.count;
		console.log("count: " + count);

		var i;
		var items = jsonObj.list; // 배열
		result += "<option selected value='0'>" + "--선택하세요--" + "</option>\n";
		for (i = 0; i < count; i++) {
			result += "<option value='" + items[i].uid + "'>";
			result += items[i].name;
			result += "</option>\n"
		} // end for
		$('#mycate select:odd').html(result);
		$('#mycate select:odd').removeAttr("disabled");
		
		$('#mycate select:odd').on('change', function() {
			// alert( this.value );
			var select = $("#mycate select:odd option:selected").val();
			if (select == this.value) {
				if(select == 0){
					$('#mycate select:last').attr("disabled", true);
					$('#mycate select:last').html("");
				} else{
					loadPage3(this.value);
				}
			}
		});

		return true;
	} else {
		alert(jsonObj.message);
		loadPage();
		return false;
	}
	return false;
}

function loadPage3(parent) {
	$.ajax({
		url : "cate_list.ajax?depth=3&parent=" + parent,
		type : "post",
		cache : false,
		success : function(data, status) {
			console.log("3번째 카테고리다!!");
			if (status == "success") {
				lastUpdate(data);
			}
		}
	});
}

function lastUpdate(jsonObj) {
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
		$('#mycate select:last').removeAttr("disabled");
		$('#mycate select:last').html(result);

		return true;
	} else {
		alert(jsonObj.message);
		loadPage();
		return false;
	}
	return false;
}
