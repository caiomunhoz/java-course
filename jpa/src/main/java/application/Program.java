package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Person;

public class Program {

	public static void main(String[] args) {
		
		Person p1 = new Person(null, "Ana De Armas", "ana@outlook.com");
		Person p2 = new Person(null, "Ryan Gosling", "ryang@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.getTransaction().commit();
		Person p = em.find(Person.class, 1);
		System.out.println(p);
		em.close();
		emf.close();
	}

}
