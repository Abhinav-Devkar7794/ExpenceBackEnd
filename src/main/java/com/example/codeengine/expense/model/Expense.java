package com.example.codeengine.expense.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity

@Table(name="expense")
public class Expense {

	
	@Id
	private Long id;
	
	private Instant expensedate;
	
	private String descript;
	
	private String location;
	
		@ManyToOne
		private Category category;

		@JsonIgnore 
		@ManyToOne
        private User user;

	public Expense() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getExpensedate() {
		return expensedate;
	}

	public void setExpensedate(Instant expensedate) {
		this.expensedate = expensedate;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//	
	/*
	 * 
	 * 
	 * 
	 * insert into expense values(100,'US' ,'2019-06-16T17:00:00.000Z',1,1);
insert into expense values(101,'Ford Musting' ,'2019-06-16T17:00:00.000Z',2,2);
insert into expense values(102,'Grand' ,'2019-06-16T17:00:00.000Z',3,1);

	 * 
	 */
	
	
	
	
}
