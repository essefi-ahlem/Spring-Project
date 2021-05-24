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
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findAll();
    Optional<Subject> findById(Long id);

	/*
    Optional<Student> findByIdAndSTUDENT_ID(Long id, Long CLASS_ID);
    */
}