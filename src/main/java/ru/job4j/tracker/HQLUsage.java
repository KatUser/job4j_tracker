package ru.job4j.tracker;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HQLUsage {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            /* working with session */

            Query<Item> query = session.createQuery(
                    "from Item as i where i.id = 3", Item.class);
            System.out.println(query.uniqueResult());

            session.close();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

}