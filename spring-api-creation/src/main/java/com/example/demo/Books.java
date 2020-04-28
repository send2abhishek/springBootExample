package com.example.demo;

import javax.validation.constraints.Size;

public class Books {
	
	private int Id;
	
	@Size(min = 2,message = "Name Should Have atleast 2 chars")
	private String name;
	
	@Size(min = 2,message = "Author Should Have atleast 2 chars")
	private String author;
	public Books(int id, String name, String author) {
		super();
		Id = id;
		this.name = name;
		this.author = author;
	}
	public int getId() {
		return Id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAuthor() {
		return author;
	}
	@Override
	public String toString() {
		return "Books [Id=" + Id + ", name=" + name + ", author=" + author + "]";
	}
	
	
	

}
