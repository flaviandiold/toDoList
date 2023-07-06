package com.learning.toDo.toDoList.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.toDo.toDoList.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer>{
	public List<Todo> findByUsername(String username);
}