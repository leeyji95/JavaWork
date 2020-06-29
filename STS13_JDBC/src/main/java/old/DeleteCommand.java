package old;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int cnt = 0;
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		WriteDAO dao = new WriteDAO();
		
		try {
			cnt = dao.deleteByUid(uid);
			
			request.setAttribute("delete", cnt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
