package hibernatecrudassignment;

import hibernatecrudassignment.Book;
import jakarta.persistence.*;

import java.util.List;

public class LibraryBookJpaApp {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("library-pu");

        EntityManager em = emf.createEntityManager();

        // ---------- CREATE ----------
        em.getTransaction().begin();

        em.persist(new Book(1, "Clean Code", "Robert Martin",
                "Programming", 550, "Available", 2008));

        em.persist(new Book(2, "Effective Java", "Joshua Bloch",
                "Programming", 650, "Available", 2018));

        em.persist(new Book(3, "Atomic Habits", "James Clear",
                "Self Help", 400, "Issued", 2019));

        em.getTransaction().commit();

        // ---------- READ BY ID ----------
        Book book = em.find(Book.class, 1);
        System.out.println(book);

        // ---------- READ ALL ----------
        List<Book> books =
                em.createQuery("FROM Book", Book.class).getResultList();
        books.forEach(System.out::println);

        // ---------- UPDATE ----------
        em.getTransaction().begin();
        Book updateBook = em.find(Book.class, 2);
        updateBook.setPrice(700);
        updateBook.setAvailabilityStatus("Issued");
        em.getTransaction().commit();

        // ---------- DELETE ----------
        em.getTransaction().begin();
        Book deleteBook = em.find(Book.class, 3);
        em.remove(deleteBook);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
