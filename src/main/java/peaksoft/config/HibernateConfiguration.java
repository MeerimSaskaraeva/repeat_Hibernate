package peaksoft.config;

import jakarta.persistence.EntityManager;
import org.hibernate.cfg.Configuration;
import peaksoft.entity.Address;
import peaksoft.entity.Country;
import peaksoft.entity.Programmer;
import peaksoft.entity.Project;

import javax.swing.text.html.parser.Entity;
import java.sql.Driver;

import static org.hibernate.cfg.AvailableSettings.*;

public class HibernateConfiguration {
    public static EntityManager getEntityManager(){
        Configuration configuration=new Configuration();
        configuration.setProperty(DRIVER,"org.postgresql.Driver");
        configuration.setProperty(URL,"jdbc:postgresql://localhost:5432/postgres");
        configuration.setProperty(USER,"postgres");
        configuration.setProperty(PASS,"2202");
        configuration.setProperty(HBM2DDL_AUTO,"update");
        configuration.setProperty(DIALECT,"org.hibernate.dialect.PostgreSQL9Dialect");
        configuration.setProperty(SHOW_SQL,"true");
        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Programmer.class);
        configuration.addAnnotatedClass(Project.class);
        configuration.addAnnotatedClass(Country.class);
        return configuration.buildSessionFactory().createEntityManager();

    }
}
