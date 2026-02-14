package hibernatecrudassignment;

import hibernatecrudassignment.User;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("library-pu");

        EntityManager em = emf.createEntityManager();

        try {
            User user = new User();
            user.setUsername("John");

            Set<String> emails = new HashSet<>();
            emails.add("john@gmail.com");
            emails.add("john.work@gmail.com");
            emails.add("john@gmail.com"); // duplicate ignored

            user.setEmails(emails);

            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();

            User fetchedUser = em.find(User.class, user.getUserId());

            System.out.println("User: " + fetchedUser.getUsername());
            System.out.println("Emails: " + fetchedUser.getEmails());

        } finally {
            em.close();
            emf.close();
        }
    }
}
