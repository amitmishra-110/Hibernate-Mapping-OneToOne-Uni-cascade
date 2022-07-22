package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.hibernate.entity.Instructor;
import com.jdbc.hibernate.entity.InstructorDetail;
import com.jdbc.hibernate.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) 
	{
			
		//Create SessionFactory
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		//Create Session
		Session  session=factory.getCurrentSession();
		
		try
		{
			
			//get the instructor by their primary key id 
			
			int theId=1;
			
		
			//start a transaction
			session.beginTransaction();
			
			Instructor tmpInstructor=session.get(Instructor.class,theId);
			
			//delete the instructor
			
			if(tmpInstructor!=null)
			{
				System.out.println("Deleting the instruction");
				
				//Note :It will also delete instructor detail table since cascasdeType.All
				session.delete(tmpInstructor);
			}
	
		
		
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
		}
		finally
		{
			factory.close();
		}
	}
	

	}
