package old;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int cnt = 0;
		WriteDAO dao = new WriteDAO();

		// 매개변수 받아오기
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		if (name != null && subject != null && name.trim().length() > 0 && subject.trim().length() > 0) {

			try {
				cnt = dao.insert(subject, content, name); // 성공하면 1
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} // end if()
		// 이 결과를 result 라는 이름의 request 객체에 담는다.
		request.setAttribute("result", cnt);
		
		
	}// end execute()

}// end Command()
