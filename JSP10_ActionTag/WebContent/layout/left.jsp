<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	int menu = 1; // menu parameter 없으면 1 page 디폴트
 	String menu_param = request.getParameter("menu");
 	if(menu_param != null){
 		try{
 			menu = Integer.parseInt(menu_param);
 		}catch(NumberFormatException e){
 
 		}
 	}
 	
 	// 1페이지에서 4페이지 범위 벗어나지 않도록 -> 파라메타 검증
 	// 1 <= menu <= 4
 	if(menu > 4) menu = 4;  // menu 값이 4 보다 크면 -> 그냥 4 에 머물도록
 	if(menu < 1) menu = 1; // menu 값이 1 보다 작으면 -> 그냥 1 에 머물도록
 	
 %>    
	<!-- left 사이트 메뉴 시작 -->
    <div class="col-sm-4">
      <h3>Side menu</h3>
      <p>Lorem ipsum dolor sit ame.</p>
      <ul class="nav nav-pills flex-column">
        <li class="nav-item">
          <a class="nav-link <%=(menu==1)?"active":""%>" <%=(menu!=1)?"href='page.jsp?menu=1'":""%>>page1</a>
        </li>
        <li class="nav-item">
          <a class="nav-link <%=(menu==2)?"active":""%>" <%=(menu!=2)?"href='page.jsp?menu=2'":""%>>page2</a>
        </li>
        <li class="nav-item">
          <a class="nav-link <%=(menu==3)?"active":""%>" <%=(menu!=3)?"href='page.jsp?menu=3'":""%>>page3</a>
        </li>
        <li class="nav-item">
          <a class="nav-link <%=(menu==4)?"active":""%>" <%=(menu!=4)?"href='page.jsp?menu=4'":""%>>page4</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#">Disabled</a>
        </li>
      </ul>
      <hr class="d-sm-none">
    </div>
    <!-- left 사이트 메뉴 끝 -->