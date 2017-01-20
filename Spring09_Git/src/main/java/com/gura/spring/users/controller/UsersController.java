package com.gura.spring.users.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gura.spring.users.service.UsersService;

//component 스캔시 bean 이 되고 또한 컨트롤러 역할을 할 수 있도록
@Controller
public class UsersController {
	//의존 객체 주입 되도록
	@Autowired
	private UsersService usersService;
	
	//2
	//ajax "/users/checkid.do 요청 처리
	@RequestMapping("/users/checkid")
	public Map<String, Object> checkid(){
		return null;
	}
	//1 
	@RequestMapping("/users/signup_form")
	public String signupForm(){
		
		return "users/signup_form";
	}
	
	// sign up 요청처리
	@RequestMapping("/users/signup")
	public String signup(){
		
		return "users/signup";
	}

}
