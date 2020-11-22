package com.bharath.student.dal;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bharath.student.dal.entities.Student;
import com.bharath.student.dal.repos.StudentRepository;


@SpringBootTest
class StudentdalApplicationTests {

	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void testCreateStudent() {

		Student student = new Student();
		student.setName("John");
		student.setCourse("Java Web Services");
		student.setFee(30d);
      
		studentRepository.save(student);

	}
	
	@Test
	public void testFindStudentById() {
		
		Optional<Student> student = studentRepository.findById(1l);
		if (student.isPresent()) {
			System.out.println(student.get());
		}
		
	}
	
	@Test
	public void testUpdateStudent() {
		Student student = studentRepository.findById(1l).get();
		student.setFee(40d);
		
		studentRepository.save(student);
	}

	@Test
	public void testDeleteStudent() {
		Student student = new Student();
		student.setId(1l);
		studentRepository.delete(student);
	}
}
