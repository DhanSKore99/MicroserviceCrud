package com.example.demo.serviceimpl;



import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Student;
import com.example.demo.repository.HomeRepository;
import com.example.demo.servicei.homeServiceI;

@Service
public  class HomeServiceImpl implements homeServiceI{
	
	@Autowired
	HomeRepository hr;

	@Override
	public void saveStudent(Student s) {
		hr.save(s);
		
	}

	@Override
	public List<Student> getAllStudents() {
		return (List<Student>)hr.findAll();
	}

	@Override
	public void updateStudent(Student s) {
		hr.save(s);
		
	}

	
	 

}
