package com.lec.sts12_validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lec.beans.WriteDTO;

public class BoardValidator implements Validator {

	// 이 Validator 가 제공하는 Class 의 인스턴스(clazz)를 유효성 검사할 수 있는가? 
	@Override
	public boolean supports(Class<?> clazz) {
		// ↓ 검증할 객체의 클래스 타입인지 확인 : WriteDTO = clazz; 가능여부 
		return WriteDTO.class.isAssignableFrom(clazz);  // 이게 뭔 의미?
	}

	// 주어진 객체(target) 에 대한 유효성 검사를 하고 
	// 유효성 검사에 오류가 있는 경우, 주어진 객체에 이 오류들을 errors 에 등록한다.
	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("validate()");
		WriteDTO dto = (WriteDTO)target;
		
		// 수행할 parameter 검증들.
		
		int uid = dto.getUid();
		if(uid == 0) { // Spring 에서 1차적 검증 끝난 후이므로, 제대로 uid값이 넘어오지 않으면 Spring 은 일단 '0' 으로 int 값 넣는다. 그 값으로 내가 에러코드 조작해야한다.
			System.out.println("uid 오류");
			// 에러 등록 rejectValue(field, errorCode) <- 반드시 쌍으로 등록되어야 한다.
			errors.rejectValue("uid", "나만의 에러코드 메시지(invalidUid)");
		}
		
		String name = dto.getName();
		if(name == null || name.trim().isEmpty()) {
			System.out.println("name 오류: 이름은 반드시 입력해야 합니다.");
			errors.rejectValue("name", "emptyName");
		}
		
		// ValidatorUtils 사용
		// 단순히 빈 폼 데이터를 처리할 때는 아래와 같이 사용 가능
		// 두번째 매개변수  "subject" 는 반드시 target 클래스 필드명이어야 한다.
		// 이는 Errors 에 등록될 때에도 동일한 field 명으로 등록된다. 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject", "emptySubject"); 
		
		

	} // end validate()

}
