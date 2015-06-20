package com.dac.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeDBOperation {
	
	static SessionFactory sFactory = HibernateUtil.getSessionFactory();
	
	public static void insert(Employee emp) {
		Session session = sFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		// this is the culprit
		session.save(emp);
		
		tx.commit();
		session.close();
	}
	
	
	public static void update(Employee emp) {
		Session session = sFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		// this is the culprit
		session.update(emp);
		
		tx.commit();
		session.close();
	}
	
	
	public static void delete(Employee emp) {
		Session session = sFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		// this is the culprit
		session.delete(emp);
		
		tx.commit();
		session.close();
	}
	
	
	public static List<Employee> listAll() {
		Session session = sFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		// this is the culprit
		Query query = session.createQuery("FROM Employee");
		List<Employee> list =  query.list();
		
		tx.commit();
		session.close();
		
		return list;
	}
	
	
	public static Employee selectById(int id) {
		Session session = sFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		// this is the culprit
		Query query = session.createQuery("FROM Employee Where id=:SET_ID");
		query.setParameter("SET_ID", id);
		List<Employee> list =  query.list();
		
		tx.commit();
		session.close();
		
		return list.get(0);
	}
	
	
	public static void main(String[] args) {
		Employee emp1 = new Employee();
		emp1.setEmpname("a");
		
		selectById(3);
	}
}
