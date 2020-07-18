<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/CSS/emp.css" />
<script src="${pageContext.request.contextPath }/JS/"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<title>직원관리프로그램</title>
</head>
<body>

	<h2>직원리스트</h2>

	<%-- 직원리스트 --%>
	<div id="list">
		<div class="d01">
			<div class="left" id="pageinfo"></div>
			<div class="right" id="pageRows"></div>
		</div>

		<div class="clear"></div>

		<form id="frmList" name="frmList">
			<table>
				<thead>
					<th>직원번호</th>
					<th>직급</th>
					<th>이름</th>
					<th>전화번호</th>
					<th>이메일</th>
				</thead>

				<tbody>
				<%-- JS 로 테이블 태그가 만들어져 들어간다 --%>
				</tbody>
			</table>
		</form>


		<%--버튼 --%>
		<div class="d01">
			<div class="left">
				<button type="button" id="btnDel" class="btn danger">삭제</button>
			</div>
			<div class="right">
				<button type="button" id="btnRegis" class="btn success">등록</button>
			</div>
		</div>
	</div>
	
	
	<%-- 등록 / 보기/ 수정 대화상자 --%>
	<div id="dlg_write" class="modal">

		<form class="modal-content animate" id="frmWrite" name="frmWrite"
			method="post">
			<div class="container">
				<h3 class="title">신규 직원 등록</h3>

				<span class="close" title="Close Modal">&times;</span> 
				
				<input type='hidden' name='emp_uid'>  <%-- 삭제나 수정 위해 필요 --%>
				
				<%--ss='d01 btn_group_header'>
					<div class='left'>
						<p id='viewcnt'></p>
					</div>				
					<div class='right'>
						<p id='regdate'></p>
					</div>	
					<div class='clear'></div>			
				</div>	 --%>
				
				직원번호: <input type="text" name="emp_num" /><br> 
				직급: <input	type="text" name="emp_dept" /><br> 
				이름: <input type="text"	name="emp_name" /><br> 
				전화번호: <input type="text" name="emp_tel" /><br>
				이메일: <input type="text" name="emp_email" />
					
				<div class='d01 btn_group_write'>
					<button type="submit" class="btn success">등록</button>
				</div>

				<div class='d01 btn_group_view'>
					<div class='left'>
						<button type='button' class='btn danger' id='viewDelete'>삭제</button>
					</div>
					<div class='right'>
						<button type='button' class='btn info' id='viewUpdate'>수정</button>
					</div>
					<div class='clear'></div>
				</div>
				
				<div class='d01 btn_group_update'>
					<div>
						<button type='button' class='btn info fullbtn' id='updateOk'>수정완료</button>
					</div>
					
				</div>
				
			</div>
		</form>
	</div>

	
</body>
</html>