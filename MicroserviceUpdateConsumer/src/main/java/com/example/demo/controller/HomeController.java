package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Student;

@RestController
public class HomeController {
	@Autowired 
	RestTemplate rt;
	
	@GetMapping("/getmsg")
	public String getMessage() {
		return "hello..";
	}
	
	@PutMapping("/updateStudentById/{id}")
	public String updateStudent(@PathVariable("id")int id,
								@RequestBody Student s) {
		String url = "http://zuul/pro/updateStudentById/"+id;
		rt.put(url, s,Student.class);
		return "Student updated..";
		
	}

}
