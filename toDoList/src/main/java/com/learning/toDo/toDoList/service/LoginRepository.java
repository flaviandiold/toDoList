package com.learning.toDo.toDoList.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.toDo.toDoList.model.User;

@Repository
public interface LoginRepository extends JpaRepository<User, String> {

}
