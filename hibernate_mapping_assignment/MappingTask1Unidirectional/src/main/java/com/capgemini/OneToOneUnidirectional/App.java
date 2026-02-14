package com.capgemini.OneToOneUnidirectional;

import jakarta.persistence.*;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Locker locker = new Locker(412,4);
		Employee employee = new Employee("Manideep","CSE",locker);
		
		em.persist(employee);
		
		Employee foundEmployee = em.find(Employee.class, employee.getEmployeeId());
		System.out.println("Found Employee: " + foundEmployee);
		
		em.getTransaction().commit();
		
	}
}
