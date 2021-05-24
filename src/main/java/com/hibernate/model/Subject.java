package com.hibernate.model;

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


@Entity
@Table(name = "SUBJECT")
public class Subject {
	
		
		
		@Id
		@GeneratedValue
		@Column(name = "SUBJECT_ID")
		private long id;

		@Column(name = "TEACHER_NAME")
		private String teacher_name;

		@Column(name = "TIME")
		private String time;
		
		@ManyToMany(cascade = {
		        CascadeType.ALL
		    })
		@JoinTable(
		        name = "SUBJECT_CLASS",
		        joinColumns = {
		            @JoinColumn(name = "SUBJECT_ID")
		        },
		        inverseJoinColumns = {
		            @JoinColumn(name = "CLASS_ID")
		        }
		    )
		List < CLASS > CLASS_LIST = new ArrayList<>();
		
		public Subject(String teacher_name, String time) {
			this.teacher_name=teacher_name ; 
			this.time=time ; 
			
		}
		
		public Subject() {
			
			
		}
		
		public Subject(String teacher_name, String time,List<CLASS> CLASS_LIST) {
			this.teacher_name=teacher_name ; 
			this.time=time ; 
			this.CLASS_LIST=CLASS_LIST ; 
			
		}
		
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

		public List < CLASS > getCLASS_LIST() {
	        return CLASS_LIST;
	    }

	    public void setCLASS_LIST(List < CLASS > CLASS_LIST) {
	        this.CLASS_LIST = CLASS_LIST;
	    }
	    
	    
        
        public void removeCLASSE(CLASS cls) {
            this.getCLASS_LIST().remove(cls);
            cls.getSubjects().remove(this);
        }        
        
        public void removeCLASSES() {
	        for (CLASS cls : new ArrayList<>(CLASS_LIST)) {
	        	removeCLASSE(cls);
	        }
	   
} 
        }
