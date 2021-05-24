package com.hibernate.controller;

import java.util.ArrayList; // import the ArrayList class

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hibernate.model.*;
import com.hibernate.repository.*;

import java.util.List; // import the ArrayList class

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class StudentController {

    
    @Autowired
    StudentReopository studentRepository;
    @Autowired
    CLASSRepository classRepository;

    @GetMapping("/Students")
    public List<Student> getAllStudents(Pageable pageable) {
    	
        List<Student> student_list = new ArrayList<Student>();  
        studentRepository.findAll().forEach(student_list::add); 
    	
    	
    	
    	
        return studentRepository.findAll() ; 

        
        
    }
   
    public Student addStudent(Student student) {
    	
    	
        CLASS class_1 = classRepository.findById(student.getCLASS().getId()).orElse(null);
        if (null == class_1) {
        	class_1 = new CLASS();
        	
        }
        class_1.setName(student.getCLASS().getName());
        class_1.setId(student.getCLASS().getId());

    	
        student.setCLASS(class_1);
        
        
        
        
        return studentRepository.save(student);
    }
    
    @PostMapping("/Students")
    public ResponseEntity<Student> createPost(@Valid @RequestBody Student student) {

    	Student s = addStudent(student);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }
    
    @PutMapping("/Students")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
    	System.out.println(student.getCLASS());
    	classRepository.save(student.getCLASS());
    	return new ResponseEntity<>(studentRepository.save(student), HttpStatus.OK);
    }

    @DeleteMapping("/Students")
    public ResponseEntity<String> deleteStudent(@RequestParam(name = "STUDENT_ID") Long studentid) {
 
    	studentRepository.deleteById(studentid);
        return new ResponseEntity<>("student with ID :" + studentid + " deleted successfully", HttpStatus.OK);
    }
    



}
