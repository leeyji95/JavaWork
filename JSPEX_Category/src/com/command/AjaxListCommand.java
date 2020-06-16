package com.command;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lec.beans.AjaxWriteList;
import com.lec.beans.CategoryDTO;

public class AjaxListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// select에 해당되는 view
		
		CategoryDTO [] dtoArr = (CategoryDTO [])request.getAttribute("list");
		
		AjaxWriteList result =  new AjaxWriteList(); // AjaxWriteList  객체 생성해주고
		
		result.setStatus((String)request.getAttribute("status"));
		result.setMessage((String)request.getAttribute("message"));
		
		if(dtoArr != null) {
			result.setCount(dtoArr.length);
			result.setList(Arrays.asList(dtoArr));  // request 에 list 담기 
		}
		
		
	//--------------------------------------------------------	
		
		ObjectMapper mapper = new ObjectMapper(); // Json 매핑할 객체 
		
		// 자바객체를 제이슨 문자열로 바꾸고, 이거를 제이슨 타입으로 변환해줌
		try {
			String jsonString = mapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(result);

			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(jsonString);
		}catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		

	} // end execute

} // end AjaxListCommand
