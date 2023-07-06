package com.learning.toDo.toDoList.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;


@Entity
public class Todo {

	public Todo() {
		
	}
	
	public Todo(int id, String username, String title, LocalDate targetDate, String status) {
		super();
		this.id = id;
		this.username = username;
		this.title = title;
		this.targetDate = targetDate;
		this.status = status;
	}

	@Id
	@GeneratedValue
	private int id;

	private String username;
	
	private String title;
	@Size(min=10, message="Enter atleast 10 characters")
	private String notes;
	private LocalDate targetDate;
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getnotes() {
		return notes;
	}

	public void setnotes(String notes) {
		this.notes = notes;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", notes=" + notes + ", targetDate="
				+ targetDate + ", status=" + status + "]";
	}

}
