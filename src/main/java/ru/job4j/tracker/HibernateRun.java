package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HibernateRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            var item = new Item();
            item.setName("Learn Hibernate");
            create(item, sessionFactory);
            System.out.println(item);
            item.setName("Learn Hibernate 5.");
            update(item, sessionFactory);
            System.out.println(item);
            Item rsl = findById(item.getId(), sessionFactory);
            System.out.println(rsl);
            delete(rsl.getId(), sessionFactory);
            List<Item> list = findAll(sessionFactory);
            for (Item it : list) {
                System.out.println(it);
            }
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static Item create(Item item, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    public static void update(Item item, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
        session.close();
    }

    public static void delete(Integer id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Item item = new Item();
        item.setId(id);
        session.delete(item);
        session.getTransaction().commit();
        session.close();
    }

    public static List<Item> findAll(SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        List<Item> result = session.createQuery("from Item", Item.class).list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public static Item findById(Integer id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Item result = session.get(Item.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
