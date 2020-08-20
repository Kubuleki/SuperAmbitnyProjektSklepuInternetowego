package hibernate.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateConfiguration {
    // obiekt sesji
    private static SessionFactory sesionFactory;

    //metoda zwracająca obiekt sesji skongigurowanej na podstawie pliku xml
    public static SessionFactory getSesionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
        sesionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sesionFactory;
    }
}
