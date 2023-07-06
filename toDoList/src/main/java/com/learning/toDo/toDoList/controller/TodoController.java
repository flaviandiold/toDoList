package com.learning.toDo.toDoList.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.learning.toDo.toDoList.model.Todo;
import com.learning.toDo.toDoList.service.TodoRepository;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("username")
public class TodoController {
	
	
	public TodoController(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	private TodoRepository todoRepository;
			
	@GetMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username = getLoggedInUsername(model);
		
		List<Todo> todos = todoRepository.findByUsername(username);
		model.addAttribute("todos", todos);
		
		return "todo";
	}

	//GET, POST
	@GetMapping("add-todo")
	public String showNewTodoPage(ModelMap model) {
		String username = getLoggedInUsername(model);
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), "Not Completed");
		model.put("todo", todo);
		return "addTodo";
	}

	@PostMapping("add-todo")
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "addTodo";
		}
		
		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
//		todoService.addTodo(username, todo.getDescription(), 
//				todo.getTargetDate(), todo.isDone());
		return "redirect:list-todos";
	}

	@GetMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		//Delete todo
		todoRepository.deleteById(id);
		return "redirect:list-todos";
		
	}

	@GetMapping("update-todo")
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		return "updateTodo";
	}

	@PostMapping("update-todo")
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "updateTodo";
		}
		
		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
	
	@GetMapping("notes-todo")
	public String notegetPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoRepository.findById(id).get();
		model.addAttribute("title",todo.getTitle());
		model.addAttribute("todo", todo);
		return "noteTodo";
	}

	@PostMapping("notes-todo")
	public String notepostPage(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "noteTodo";
		}
		
		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}

	private String getLoggedInUsername(ModelMap model) {
		String username = (String) model.get("username");
		return username;
	}

}