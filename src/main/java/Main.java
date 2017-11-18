import model.Order;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        User user1 = new User ();
        user1.setName ("Dariusz");
        user1.setSurname ("Roza");
        user1.setAddress ("Bydgoszcz");

        User user2 = new User ();
        user2.setName ("Bolek");
        user2.setSurname ("Lolek");
        user2.setAddress ("Wawa");

        Order order1 = new Order ();
        order1.setIngredients ("pieprz, sól");
        order1.setOrderDate (LocalDate.now ());
        Order order2 = new Order ();
        order2.setIngredients ("cukier");
        order2.setOrderDate (LocalDate.now ());
        Order order3 = new Order ();
        order3.setIngredients ("klops");
        order3.setOrderDate (LocalDate.now ());


        SessionFactory sessionFactory = new org.hibernate.cfg.Configuration ().configure ().buildSessionFactory ();
        Session session = sessionFactory.openSession ();
        session.beginTransaction ();

        order1.setIdUser (user1);
        order2.setIdUser (user1);
        order3.setIdUser (user2);

        session.save (order1);
        session.save (order2);
        session.save (order3);
        session.getTransaction ().commit ();
        session.close ();

    }
}
