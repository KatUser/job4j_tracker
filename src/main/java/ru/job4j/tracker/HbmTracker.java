package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Collections;
import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private static final StandardServiceRegistry REGISTRY = new StandardServiceRegistryBuilder()
            .configure().build();
    private static final SessionFactory SESSION_FACTORY = new MetadataSources(REGISTRY)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = SESSION_FACTORY.openSession();
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        Session session = SESSION_FACTORY.openSession();
        int affectedRows = 0;
        try {
            session.beginTransaction();
            affectedRows = session.createQuery("""
                            UPDATE Item
                            SET name = :fName,
                            created = :fCreated
                            WHERE id = :fId
                            """)
                    .setParameter("fName", item.getName())
                    .setParameter("fCreated", item.getCreated())
                    .setParameter("fId", id)
                    .executeUpdate();

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return affectedRows > 0;
    }

    @Override
    public void delete(int id) {
        Session session = SESSION_FACTORY.openSession();
        try {
            session.beginTransaction();
            session.createQuery("DELETE Item WHERE id = :fId")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> foundItems = Collections.emptyList();
        Session session = SESSION_FACTORY.openSession();
        try {
            session.beginTransaction();
            foundItems = session.createQuery("from Item",
                            Item.class).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return foundItems;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = SESSION_FACTORY.openSession();
        List<Item> foundItems = Collections.emptyList();
        try {
            session.beginTransaction();
            foundItems = session.createQuery(
                            "from Item as i WHERE i.name = :fKey", Item.class
                    )
                    .setParameter("fKey", key)
                    .getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return foundItems;
    }

    @Override
    public Item findById(int id) {
        Session session = SESSION_FACTORY.openSession();
        Item foundItem = null;
        try {
            session.beginTransaction();
            foundItem = session.createQuery(
                            "from Item as i WHERE i.id = :fId", Item.class
                    )
                    .setParameter("fId", id)
                    .uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return foundItem;
    }

    public static void deleteAllItems() {
        Session session = SESSION_FACTORY.openSession();
        try {
            session.beginTransaction();
            session.createQuery("DELETE from Item").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(REGISTRY);
    }
}