package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
 
@Getter
@Setter
@Entity
@Table(name = "CLASS")
public class CLASS {

	@Id
	@GeneratedValue
	@Column(name = "CLASS_ID")
	private long id;

	@Column(name = "NAME")
	private String name;
	
	@ManyToMany(mappedBy = "CLASS_LIST", cascade = { CascadeType.ALL })
	@JsonIgnore
    private List<Subject> subjects = new ArrayList<Subject>();

	/*
	@OneToMany(mappedBy = "CLASS", cascade = CascadeType.ALL, orphanRemoval = true)
    CLA
    private List<Student> students = new ArrayList<Student>();
	
	
	public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    */
    
	
	public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
    
    @JsonCreator
	public CLASS() {

	}

	public CLASS(String name) {
		this.name = name;
	}
	
	public CLASS(String name,List<Subject> subjects) {
		this.name = name;
		this.subjects =  subjects ; 
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	@Override
	public String toString() {
		return "Class [id=" + id + ", name=" + name + "students =] ";
	}

}
