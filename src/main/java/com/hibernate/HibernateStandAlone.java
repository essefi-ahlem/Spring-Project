

package com.hibernate;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Session;

import com.hibernate.model.CLASS;
import com.hibernate.model.Student;
import com.hibernate.model.Subject;


public class HibernateStandAlone {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Student student1 = new Student("Sam","Disilva","Maths");
		Student student2 = new Student("Joshua", "Brill", "Science");
		Student student3 = new Student("Peter", "Pan", "Physics");
		
		CLASS Class = new CLASS("1 ere Aa");


		student1.setCLASS(Class);
		student2.setCLASS(Class);
		student3.setCLASS(Class);
		
		

		
		
		


		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.persist(Class);
		
		session.persist(student1);
		session.persist(student2);
		session.persist(student3);
		
		List<Student> students = (List<Student>)session.createQuery("from Student ").list();
		for(Student s: students){
			System.out.println("Student Details : "+s);
			System.out.println("Student University Details: "+s.getCLASS());
		}
		
		session.getTransaction().commit();
		session.close();  
		
		
		CLASS Class2 = new CLASS("2 ere Aa");
		CLASS Class3 = new CLASS("3 ere Aa");
		CLASS Class4 = new CLASS("4 ere Aa");
		
		
		
		List<CLASS> Class_list = new ArrayList<>();
		
		Class_list.add(Class2);
		Class_list.add(Class3);	

		Subject s1 = new Subject("iyed","13:00",Class_list);

		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.persist(Class2);
		
		session.persist(Class3);
		session.persist(s1);

		session.getTransaction().commit();
		session.close();  

		/*        
		CLASS Class5 = new CLASS("5 ere Aa");
		Student student5 = new Student("Sam","Disilva","Maths");
		Student student6 = new Student("sam2", "Brill", "Science");
		Student student7 = new Student("sam3", "Pan", "Physics");

		List<Student> students_same_class = new ArrayList<>();
		
		students_same_class.add(student5);
		students_same_class.add(student7);
		students_same_class.add(student6);
		Class5.setStudents(students_same_class);
		System.out.println("-------------------------------------------------");
		
		System.out.println(Class5);

		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.persist(Class5);
		
		session.persist(student5);
		session.persist(student6);
		session.persist(student7);
		
		

		session.getTransaction().commit();
		session.close();  
		*/
		
	
		
		
	}

}








