package com.example.codeengine.expense.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/*
 * @AllArgsConstructor
   @NoArgsConstructor
   @Data
 * 
 */
@Entity

@Table(name="category")

public class Category {

	@Id
	private Long id;
	
	
	@NotNull
	private String name;
	
	
	
	
	public Category() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}

	
	
	

}
