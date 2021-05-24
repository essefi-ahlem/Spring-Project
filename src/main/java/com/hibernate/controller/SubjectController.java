package com.hibernate.controller;

import java.util.ArrayList; // import the ArrayList class

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

import com.hibernate.model.*;
import com.hibernate.repository.*;

import java.util.List; // import the ArrayList class
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class SubjectController {

    
    @Autowired
    StudentReopository studentRepository;
    @Autowired
    CLASSRepository classRepository;
    @Autowired
    SubjectRepository subjectRepository;

    
    private SubjctDto mapEntityToDto(Subject subject) {
    	SubjctDto responseDto = new SubjctDto();
        responseDto.setTeacher_name(subject.getTeacher_name());
        responseDto.setId(subject.getId());
        responseDto.setTime(subject.getTime());

        responseDto.setClass_list(subject.getCLASS_LIST().stream().collect(Collectors.toList()));
        return responseDto;
    }
    
  
   
    private void mapDtoToEntity(SubjctDto subjectDto, Subject subject) {
    	subject.setTeacher_name(subjectDto.getTeacher_name());
    	subject.setTime(subjectDto.getTime());
    	
        if (null == subject.getCLASS_LIST()) {
            subject.setCLASS_LIST(new ArrayList<>());
        }

    	System.out.println(subjectDto.getClass_list());  
        subjectDto.getClass_list().stream().forEach(clas -> {
            CLASS cl = classRepository.findByName(clas.getName());

            if (null == cl) {
                cl = new CLASS();
                cl.setSubjects(new ArrayList<>());
                
            }
            cl.setName(clas.getName());
            classRepository.save(cl);

            subject.getCLASS_LIST().add(cl);
        }
        );
        
    	
        
        
    }
  
    
    
    
    @GetMapping("/Subjects")
    public ResponseEntity<List<SubjctDto>> getAllSubjects() {
        
    	List<SubjctDto> subjectDtos = new ArrayList<>();
        List<Subject> subjects = subjectRepository.findAll();
        subjects.stream().forEach(subj -> {
        	SubjctDto subjectDto = mapEntityToDto(subj);
        	subjectDtos.add(subjectDto);
        });

    	
        return new ResponseEntity<>(subjectDtos, HttpStatus.OK);
    }
    
    public SubjctDto addSubject(SubjctDto studentDto) {
        Subject subj = new Subject();
        mapDtoToEntity(studentDto, subj);

        Subject savedSubject = subjectRepository.save(subj);
        
        return mapEntityToDto(savedSubject);
    } 
    
    
    @PostMapping("/Subjects")
    @ResponseBody
    public ResponseEntity<SubjctDto> getAllStudents(@RequestBody SubjctDto subjectDto) {
     

    	SubjctDto std = addSubject(subjectDto);
    	
        return new ResponseEntity<>(std, HttpStatus.CREATED);
    }
    
    
  
    public SubjctDto updateStudent(Long id, SubjctDto subjectDto) {
        Subject sbj = subjectRepository.getOne(id);
        subjectDto.getClass_list().clear();
        mapDtoToEntity(subjectDto, sbj);        
        
        return mapEntityToDto(subjectRepository.save(sbj));
    }
    
    @PutMapping("/Subjects/{id}")
    public ResponseEntity<SubjctDto> updateStudent_REQ(@PathVariable(name = "id") Long id, @RequestBody SubjctDto subj) {
    	SubjctDto std = updateStudent(id, subj);
        return new ResponseEntity<>(std, HttpStatus.CREATED);
    }
 
    
    public String deleteStudent(Long subjid) {
        java.util.Optional<Subject> subject = subjectRepository.findById(subjid);
        
        //Remove the related courses from student entity.
        if(subject.isPresent()) {
        	subject.get().removeCLASSES();
            subjectRepository.deleteById(subject.get().getId());
            return "subject with id: " + subjid + " deleted successfully!";
        }
        return null;
    }
    
    @DeleteMapping("/Subjects/{id}")
    public ResponseEntity<String> deleteStudent_REQ(@PathVariable(name = "id") Long studentId) {
        String message = deleteStudent(studentId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
