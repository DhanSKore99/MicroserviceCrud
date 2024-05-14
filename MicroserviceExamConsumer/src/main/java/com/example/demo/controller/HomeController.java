package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Student;

@RestController
public class HomeController {
	
    @Autowired 
    RestTemplate rt;
	
	@GetMapping("/getProData")
	public String preConLogin() {
		return "Welcome to Examination consumer..!!";
	}
	
	@GetMapping("/getMyConsumer")
	public String preConumerLogin() {
		String url="http://zuul/pro/getMyProducer";
		String msg = rt.getForObject(url, String.class);
		return msg;
	}
	
	@GetMapping("/getAllStudents")
	public List<Student>getAllStudents(){
		String url="http://zuul/pro/getAllStudents";
		List<Student>list = rt.getForObject(url, List.class);
		return list;
	}
	
	@PostMapping("/post")
	public Student postStudentData(@RequestBody Student s) {
		String url="http://zuul/pro/postMyProducer";
		rt.postForObject(url, s, Student.class);
		return s;
		
	}
	
	@PutMapping("/updateStudentById/{id}")
	public String updateStudent(@PathVariable("id")int id,
								@RequestBody Student s) {
		String url = "http://zuul/pro/updateStudentById/"+id;
		rt.put(url, s,Student.class);
		return "Student updated..";
		
	}

	public void hellojava()
	{	System.out.println("Hello.. I am Controller..");
	}

}
