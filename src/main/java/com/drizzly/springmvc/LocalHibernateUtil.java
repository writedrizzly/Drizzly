/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc;

import com.drizzly.springmvc.model.DrMaCategory;
import com.drizzly.springmvc.model.DrMaEmployee;
import com.drizzly.springmvc.model.DrMaFees;
import com.drizzly.springmvc.model.DrMaStudent;
import com.drizzly.springmvc.model.DrTrFeesDue;
import com.drizzly.springmvc.model.DrTrLoan;
import com.drizzly.springmvc.model.DrTrLoanDue;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Component;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author rajaguru
 */
@Component
public class LocalHibernateUtil {

    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            // config file.
            //Configuration config = new Configuration().configure(LocalHibernateUtil.class.getResource("/hibernate.cfg.xml"));
            Configuration config = new Configuration().configure();
            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
            serviceRegistryBuilder.applySettings(config.getProperties());
            serviceRegistry = serviceRegistryBuilder.build();
            config.addAnnotatedClass(DrMaEmployee.class)
                    .addAnnotatedClass(DrMaStudent.class)
                    .addAnnotatedClass(DrTrFeesDue.class)
                    .addAnnotatedClass(DrMaFees.class)
                    .addAnnotatedClass(DrMaCategory.class)
                    .addAnnotatedClass(DrTrLoan.class)
                    .addAnnotatedClass(DrTrLoanDue.class);
            sessionFactory = config.buildSessionFactory(serviceRegistry);
        } catch (Exception ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public EntityManager getEntityManager() {

        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("ocom.drizzly.Drizzly-PU");
            em = emf.createEntityManager();
            System.out.println("Enity manager created :: " + em);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
//        finally {
//            if (em != null) {
//                em.close();
//            }
//            if (emf != null) {
//                emf.close();
//            }
//        }
        return em;
    }
}
