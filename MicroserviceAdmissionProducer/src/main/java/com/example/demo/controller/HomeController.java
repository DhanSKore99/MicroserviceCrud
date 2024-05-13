package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Student;
import com.example.demo.servicei.homeServiceI;

@RestController
public class HomeController {
	@Autowired
	homeServiceI hs;
	
	@GetMapping("/getConData")
	public String preProLogin() {
		return "Welcome to Admission Producer..!!";
	}
	
	@GetMapping("/getMyProducer")
	public String preProducerLogin() {
		return "Welcome to Admission Producer..!!";
	}
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents(){
		return hs.getAllStudents();
	}
	
	@PostMapping("/postMyProducer")
	public Student postStudentData(@RequestBody Student s) {
		hs.saveStudent(s);
		System.out.println("Student Posted Successfully");
		return s;
		
	}
	
	@PutMapping("/updateStudentById/{id}")
	public String updateStudent(@PathVariable("id")int id,
								@RequestBody Student s) {
		if(id==s.getId()) {
			hs.updateStudent(s);
			return "Student updated..!! ";
		}
		else {
			hs.saveStudent(s);
			return "New Student saved..!!";
		}
		
	}

	
	

}
