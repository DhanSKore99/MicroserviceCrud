package com.example.demo.servicei;

import java.util.Iterator;
import java.util.List;

import com.example.demo.Model.Student;

public interface homeServiceI {

	void saveStudent(Student s);

	List<Student> getAllStudents();

	void updateStudent(Student s);
	
	

}
