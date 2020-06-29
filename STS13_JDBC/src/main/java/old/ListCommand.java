package old;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		WriteDAO dao = new WriteDAO(); // DAO 객체 생성  => 여기서는 서블릿에서 생성한다. 아까는 JSP에서 빈객체로 생성했음 그 차이 알기
		WriteDTO [] arr = null;
		
		try {
			// 트랜잭션 수행
			arr = dao.select();
			
			// 이 결과를 request 객체에 담는다. 애시당초 서버가 request 보내어 
			// 이 결과를 "list" 라는 이름으로 담겠다.!
			// "list" 란  name 으로 request 에 arr 값 저장
			// 즉, request 에 담아서 컨트롤러에 전달되는 셈.
			request.setAttribute("list", arr);
			
			
		} catch (SQLException e) {
			// 만약 ConnectionPool 을 사용한다면 
			// ↑ 여기서 NamingException 도 catch 해야 한다
			e.printStackTrace();
		}

	}

}
