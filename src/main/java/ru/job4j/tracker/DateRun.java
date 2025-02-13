package ru.job4j.tracker;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;

public class DateRun {
    public static void main(String[] args) {
        var registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try (var sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory()) {
            var session = sf
                    .withOptions()
                    .jdbcTimeZone(TimeZone.getTimeZone("UTC"))
                    .openSession();
            session.beginTransaction();
            var item = new Item();
            item.setName("testing Asia/Tokyo3");
            item.setCreated(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
            session.persist(item);
            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
