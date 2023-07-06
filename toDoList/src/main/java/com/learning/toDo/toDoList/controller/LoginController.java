package com.learning.toDo.toDoList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.learning.toDo.toDoList.model.User;
import com.learning.toDo.toDoList.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("username")
public class LoginController {
	
	
	public LoginController(LoginService service) {
		super();
		this.service = service;
	}
	
	private LoginService service;

	@GetMapping("/")
	public String gotoLoginPage() {
		return "login";
	}
	
	@PostMapping("/")
	public String gotoWelcomePage(@RequestParam String username, @RequestParam String password, ModelMap model) {
		boolean user = service.isPresent(username);
		if(!user) {
			model.addAttribute("umessage","No such user exists");
			return "login";
		}
		boolean pass = service.hasPassword(username,password);
		if(!pass) {
			model.addAttribute("pmessage","Bad Credentials");
			return "login";
		}
		model.addAttribute("uname", service.getName(username));
		model.addAttribute("username", username);
		return "welcome";
	}
	
	@GetMapping("/sign-up")
	public String signUp() {
		return "signup";
	}
	
	@PostMapping("/sign-up")
	public String signingUp(User user, ModelMap model, BindingResult result) {
		boolean name = service.isPresent(user.getUsername());
		if(name) {
			model.addAttribute("umessage","Such a username exists, choose another name");
			return "signup";
		}
		service.add(user);
		
		return "redirect:/";
	}
	
	@GetMapping("/welcome")
	public String welcome(ModelMap model){
		model.addAttribute("uname", service.getName((String) model.get("username")));
		return "welcome";
	}
	
	@GetMapping("/logout")
	public String logoutAdmin(ModelMap model, HttpSession session, SessionStatus status) {

		status.setComplete();
		model.remove("username");
		session.invalidate();
		return "redirect:/";
	}
	
}
