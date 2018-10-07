import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa");


       // Department rd = new Department(1,"Research and development","Israel");
        Account_Rank admin_rank = new Account_Rank("admin");
        Account_Rank regular_rank = new Account_Rank("regular");
        Account_Rank silver_rank = new Account_Rank("silver");
        Account_Rank gold_rank = new Account_Rank("gold");
        Account_Status active_status = new Account_Status("active");
        Account_Status waiting_for_app_status = new Account_Status("waiting_for_approve");
        Account_Status disabled_status = new Account_Status("disabled");
        User mariel = new User("marielc","mariel_password","mariel.cherkassky@gmail.com",
                "Mariel","Cherkassky",admin_rank,active_status,1234567);
        User maor = new User("maors","maor_password","maor.shmueli@gmail.com",
                "Maor","Shmueli",admin_rank,active_status,2345678);

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        /*Save ranks in the ranks table*/
        entityManager.persist(admin_rank);
        entityManager.persist(silver_rank);
        entityManager.persist(gold_rank);
        entityManager.persist(regular_rank);
        entityManager.persist(admin_rank);

        /*Save statuses in the statuses table*/
        entityManager.persist(active_status);
        entityManager.persist(waiting_for_app_status);
        entityManager.persist(disabled_status);

        /*Save users in the users table*/
        entityManager.persist(mariel);
        entityManager.persist(maor);

        entityManager.getTransaction().commit();
        TimeUnit.MINUTES.sleep(1);
        entityManagerFactory.close();
    }
    
}
