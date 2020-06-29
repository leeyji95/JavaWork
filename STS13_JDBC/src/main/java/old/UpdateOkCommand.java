package old;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
		int cnt = 0;

		int uid = Integer.parseInt(request.getParameter("uid"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		WriteDAO dao = new WriteDAO(); // DAO 객체 생성  => 여기서는 서블릿에서 생성한다. 아까는 JSP에서 빈객체로 생성했음 그 차이 알기

		try {
			cnt = dao.update(uid, subject, content);
			
			request.setAttribute("updateOk", cnt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
