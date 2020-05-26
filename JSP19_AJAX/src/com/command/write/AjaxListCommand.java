package com.command.write;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;
import org.json.JSONArray;
import org.json.JSONObject;

import com.lec.beans.WriteDTO;

public class AjaxListCommand implements Command {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// parameter 받아오기, 없으면 json 동작 디폴트로. 
		String reqType = request.getParameter("reqType");
		if(reqType == null) reqType = "json";
		
		
		// "xml" 혹은 "json" 으로 response 하기
		switch(reqType) {
		case "xml":
			responseXML(request, response);
			break;
		case "json":
			responseJSON(request, response); 
			break;
		default:
			responseJSON(request, response);  //  json 동작 디폴트
		} // end switch
	}// end execute
	
	private void responseJSON(HttpServletRequest request, HttpServletResponse response) {
		WriteDTO [] dtoArr = (WriteDTO [])request.getAttribute("list");
		
		JSONObject jsonOutput = new JSONObject(); // 최종결과는 object
		
		if(dtoArr == null) {
			jsonOutput.put("status", "FAIL");  // dto 가 null로 넘어오면, status 값에 FAIL 집어넣겠다.
		}else {
			jsonOutput.put("status", "OK");  // 오브젝트에 property-value 추가 
			int count = dtoArr.length;
			jsonOutput.put("count", count);
			
			// 글 목록(배열에 담기 위해 )
			JSONArray dataArr = new JSONArray(); // array
			
			for(int i = 0; i < count; i++) {
				JSONObject dataObj = new JSONObject();
				
				dataObj.put("uid", dtoArr[i].getUid());
				dataObj.put("name", dtoArr[i].getName());
				dataObj.put("subject", dtoArr[i].getSubject());
				dataObj.put("content", dtoArr[i].getContent());
				dataObj.put("viewcnt", dtoArr[i].getViewCnt());			
				dataObj.put("regdate", dtoArr[i].getRegDate());
				
				
				// array 에 추가
				dataArr.put(dataObj);    // 배열의 경우, 값만 넣으면 되니까 
			}
			jsonOutput.put("data", dataArr);
		}
		// 오브젝트와 배열에 값을 넣을 때 모두 put 사용한다.
		String jsonString = jsonOutput.toString()	; //JSON 객체가 --> String 변환
		response.setContentType("application/json; charset=utf-8"); // MIME 설정
		
		try {
			response.getWriter().write(jsonString); // response 내보내기 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // end JSON
	

	
	private void responseXML(HttpServletRequest request, HttpServletResponse response) {
		
		WriteDTO [] dtoArr = (WriteDTO [])request.getAttribute("list");
		
		Document dom = new Document();
		
		Element rootElement = new Element("WriteList");  // <WriteList>..</WriteList>
		
		dom.setRootElement(rootElement);
		
		Element statusElement = new Element("status");
		
		if(dtoArr == null) {
			statusElement.setText("FAIL");
		} else {
			statusElement.setText("OK");
			
			// 데이터 개수
			int count = dtoArr.length;
			Element countElement = new Element("Count").setText("" + count)
					.setAttribute("id", "ccc")
					.setAttribute("pw", "xxx")
					;
			
			rootElement.addContent(countElement);
			
			for(int i = 0; i < count; i++) { // 글의 개수만큼 데이터를 만든다.
				Element dataElement = new Element("Data");
				
				dataElement.addContent(new Element("uid").setText(dtoArr[i].getUid() + ""));
				dataElement.addContent(new Element("name").setText(dtoArr[i].getName() + ""));
				dataElement.addContent(new Element("subject").setText(dtoArr[i].getSubject() + ""));
				dataElement.addContent(new Element("content").setText(dtoArr[i].getContent() + ""));
				dataElement.addContent(new Element("viewcnt").setText(dtoArr[i].getViewCnt() + ""));
				dataElement.addContent(new Element("regdate").setText(dtoArr[i].getRegDate() + ""));
				
				rootElement.addContent(dataElement);
			}
			
		}
		rootElement.addContent(statusElement);  // rootElment가 모야? WritList. 얘의 새끼로 들어간다. 
		
		
		// xmloutputter 객체를 가지고 xml 을 문자열로 뽑아낼 수 있다. 
		XMLOutputter xmlOutputter = new XMLOutputter();  // jdom 에 있는 객체 
		System.out.println(xmlOutputter.outputString(dom)); // 콘솔창 테스트 용
		
		try {
			response.setContentType("application/xml; charset=utf-8"); // text/xml 해도 가능
			response.getWriter().write(xmlOutputter.outputString(dom)); // dom을 문자열로 만들어서 response 하는 겁니당.
		} catch (IOException e){
			e.printStackTrace();
			
		}
		
	
	} // end XML

} // end class
