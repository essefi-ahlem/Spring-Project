package com.hibernate.repository;
import java.util.Optional;

import com.hibernate.model.*;
import com.hibernate.repository.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List; // import the ArrayList class





@Repository
public interface CLASSRepository extends JpaRepository<CLASS, Long> {
    List<CLASS> findAll();
    
    public CLASS findByName(String courseName);
	/*
    Optional<Student> findByIdAndSTUDENT_ID(Long id, Long CLASS_ID);
    */
}