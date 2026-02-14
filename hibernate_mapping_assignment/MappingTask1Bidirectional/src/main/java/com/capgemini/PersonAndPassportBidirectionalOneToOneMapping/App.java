package com.capgemini.PersonAndPassportBidirectionalOneToOneMapping;

import jakarta.persistence.*;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Passport passport = new Passport(81892371l,"21-10-2025","21-10-2035");
		Person person = new Person("Manideep","09-10-2003",passport);
		em.persist(person);
		person.setPassport(passport);
		em.getTransaction().commit();
	}
}