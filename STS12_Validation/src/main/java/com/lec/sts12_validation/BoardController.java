package com.lec.sts12_validation;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.beans.WriteDTO;

@Controller // Controller 명시 후 반드시 서버 재시작 가동하기
@RequestMapping("/board")
public class BoardController {

	@RequestMapping("write.do")
	public String write() {
		return "board/write";
	}
	
	@RequestMapping("writeOk.do")
	public String writeOk(@ModelAttribute("w") @Valid WriteDTO dto,  // @Valid -> 바인딩할 때 적용하겟ㅅ다.
			BindingResult result) {// <- validator 가 유효성 검사를 한 결과가 담긴 객체이다.  // 컨테이너 내부에서 에러 처리해준다. 이걸 추가해주면 uid 가 numberfomat 나지 않고 '0'으로 읽어들인다.
		System.out.println("writeOk():" + dto.getUid() + " : " + dto.getName());
//		System.out.println("에러 개수: " + result.getErrorCount()); // 바인딩과정에서 발생한 에러 개수 
	//	System.out.print("validate전(spring에서 검증한 것만)"); showErrors(result);
		
		String page = "board/writeOk";  // <- 정상적으로 진행될 경우
		
		// validator 객체 생성  -> 하면 내가 작성한 에러 코드가 동작할 것
//		BoardValidator validator = new BoardValidator();
//		validator.validate(dto, result);
		System.out.println("validate후"); showErrors(result);    // validate() 직접 호출하지 않았음. 그러나 바인딩하는 시점에서 @InitBinder 로 등록된 validator()로 검증한다!
																// 그게 위에 @Valid 한 곳이다. 왜>? 폼데이터들은 WriteDTO 커맨드 객체에 바인딩 되기 때문에. 
		if(result.hasErrors()) { // 에러가 하나라도 있다면 
			page = "board/write"; // 원래 폼으로 돌아가기!
		}
		
		return page;
	}
	
	// 도우미 함수
	// error 에 담겨 있는 에러들을 모두 출력하기 
	public void showErrors(Errors errors) {
		if(errors.hasErrors()) { // error 가 하나라도 있다면
			System.out.println("에러 개수 : " + errors.getErrorCount());
			System.out.println("\t[field]\t|[code]");
			List<FieldError> errList = errors.getFieldErrors(); // error 목록 뽑아내기
			
			for(FieldError err : errList) {
				System.out.println("\t" + err.getField() + "\t|" + err.getCode());
			}
		} else {
			System.out.println("에러 없음");
		}
	} // end showErrors()
	
	// Spring 내부에서 먼저 검증을 1차적으로 해준다. 그걸 도우미 함수에서 볼 수 있다.
	// 그런 다음에 내가 만든 검증 코드가 동작하는 것이다.
	
	
	
	// 이 컨트롤러 클래스의 handler 에서 폼 데이터를 바인딩 할 때 검증하는 개체 지정 
	@InitBinder 
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new BoardValidator());
		
	}
	
	
	
	
	
	
	
	
	
}


