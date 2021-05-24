package com.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
 
@Getter
@Setter
public class SubjctDto {
	
	public SubjctDto(){
		
	}
	
	
public SubjctDto(String teacher_name,String time,List < CLASS > CLASS_LIST){
	this.CLASS_LIST = CLASS_LIST ; 
	this.teacher_name = teacher_name ; 
	this.time = time ; 
		
	}

	
	private long id;

	private String teacher_name;

	
	private String time;
	

	private List < CLASS > CLASS_LIST = new ArrayList<CLASS>();


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTeacher_name() {
		return teacher_name;
	}


	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}

	public List<CLASS> getClass_list() {
		return CLASS_LIST;
	}


	public void setClass_list(List<CLASS> cLASS_LIST) {
		CLASS_LIST = cLASS_LIST;
	}

	

	
}
