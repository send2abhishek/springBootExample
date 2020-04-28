package com.example.demo;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {
	
	@Autowired
	private UserDaoService service;
	
	@GetMapping("/books")
	public List<Books> getAllBooks(){
		
		 return service.getAllBooks();
	}
	@GetMapping("/demo")
	public ResponseEntity<String> getDemo(){
		
		 return ResponseEntity.status(HttpStatus.CREATED)
			 .header("Custom Header","custom")
			 .body("Abhishek Aryan");
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/")
	public Employee getStart() {
		
		 return new Employee(1,"ABhishek Aryan");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Books> getDetails(@PathVariable int id) {
		
		Books b=service.findOne(id);
		
		if(b==null) {
			throw new UserNotFoundException("user id passed, for which user is not present");
		}
		
		HttpHeaders header=new HttpHeaders();
		header.add("Custom Header", "custom value");
		
		 return new ResponseEntity<>(b,header,HttpStatus.OK);
	}
	
	@PostMapping("/books")
	public ResponseEntity<Books> newBooks(@Valid @RequestBody Books b) {
		
		Books book=service.save(b);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(book);
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Books> deleteBooks(@PathVariable int id){
		
		Books book=service.findOneDelete(id);
		if(book==null) {
			throw new UserNotFoundException("user id passed, for which user is not present");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(book);
		
	}

}
