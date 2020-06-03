package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.FileDAO;
import com.lec.beans.FileDTO;
import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class UpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		WriteDAO dao = new WriteDAO(); // DAO 객체 생성  => 여기서는 서블릿에서 생성한다. 아까는 JSP에서 빈객체로 생성했음 그 차이 알기
		WriteDTO [] arr = null;
		
		// 첨부파일 정보도 update 화면에 보여주어야 한다
		FileDAO fileDao = new FileDAO();
		FileDTO [] fileArr = null;		
		
		int uid = Integer.parseInt(request.getParameter("uid"));  // 매개변수 검증 필요

		try {
			arr = dao.selectByUid(uid);  // 읽기 only
			request.setAttribute("list", arr);
			
			if(arr != null && arr.length == 1) { // 
				fileArr = fileDao.selectFilesByWrUid(uid);
				request.setAttribute("file", fileArr);
			}		
		} catch (SQLException e) { // 만약 ConnectionPool 을 사용한다면 여기서 NamingException 도 catch 해야 한다  
			e.printStackTrace();
		}
		
		
	} // end execute()

} // end Command 
