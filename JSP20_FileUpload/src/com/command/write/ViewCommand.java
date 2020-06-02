package com.command.write;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.FileDAO;
import com.lec.beans.FileDTO;
import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class ViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		WriteDAO dao = new WriteDAO();
		WriteDTO [] arr = null;
		
		// 첨부파일
		FileDAO fileDao = new FileDAO();
		FileDTO [] fileArr = null;
		

		// uid 파라미터 받아오기.
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		try {
			arr = dao.readByUId(uid);
			
			
			// view 이름으로 request 결과 담아 Controller 에 보내겠다.
			request.setAttribute("view", arr);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 첨부파일 읽어 들이기 
		try {
			if(arr != null && arr.length == 1) {
				fileArr = fileDao.selectFilesByWrUid(uid); // 첨부파일 읽어오기(데이터베이스에서 DB 정보만 읽어온 것임.(•alarm-black-18dp.svg) 이런식으로 화면에 보임) 
				
				// 이미지 파일 여부 세팅
				String realPath = "";
				String saveFolder = "upload";
				ServletContext context = request.getServletContext();
				realPath = context.getRealPath(saveFolder);
				
				for(FileDTO fileDto : fileArr) {
					String downloadedFilePath = realPath + File.separator + fileDto.getFile(); 
					BufferedImage imgData = ImageIO.read(new File(downloadedFilePath));
					if(imgData != null) {
						fileDto.setImage(true);  // 이미지 임! 
					}
				} //   realPath 까지는 ContextPath 까지.    // fileDto.getFile() 야는 file의 물리적인 경로가 나옴
				// 물리적인 경로로 왔을 때 이미지인지 아닌지를 판별하고, 이미지라면 BufferedImage 를 리턴한다.
				
				request.setAttribute("file", fileArr);  // file 이라는 이름에 결과값 담아서 view 로 보내줌 
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	} // end execute()

} // end Command
