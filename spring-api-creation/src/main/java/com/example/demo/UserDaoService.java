package com.example.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<Books> books=new ArrayList<>();
	
	
	static {
		
		books.add(new Books(1,"Spring Boot in 2 days","Abhishek Aryan"));
		books.add(new Books(2,"React Js in 2 days","Abhishek Aryan"));
		books.add(new Books(3,"Node Js in 2 days","Abhishek Aryan"));
	}
	
	public List<Books> getAllBooks(){
		
		return books;
	}
	
	public Books save(Books b) {
		
		books.add(b);
		return b;
	}
	
	public Books findOne(int id) {
		
		for(Books book:books) {
			
			if(book.getId()==id) {
				return book;
			}
		}
		
		return null;
	}
	
	public Books findOneDelete(int id) {
			
			Iterator<Books> iterator=books.iterator();
			while(iterator.hasNext()) {
				Books b=iterator.next();
				if(b.getId()==id) {
					iterator.remove();
					return b;
				}
			}
			
			return null;
		}

}
