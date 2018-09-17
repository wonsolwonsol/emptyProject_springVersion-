package com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.dto.Login;
import com.dto.Member;

public class TestValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Login.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors error) {
		System.out.println(obj);
		if(obj instanceof Login) {
			Login user = (Login) obj;
			if(user.getUserid().length() == 0) {
				error.rejectValue("userid", "required", "default");				
			}			
			if(user.getPasswd() == null || user.getPasswd().length() == 0) {
				error.rejectValue("passwd", "length", "default");
			}
		}

	}

}
