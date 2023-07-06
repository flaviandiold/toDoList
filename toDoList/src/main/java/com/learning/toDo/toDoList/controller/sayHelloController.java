package com.learning.toDo.toDoList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class sayHelloController {

	@RequestMapping("sya-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! This is amazing";
	}
}
