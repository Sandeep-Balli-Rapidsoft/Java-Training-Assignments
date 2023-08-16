package com.Config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.ControllerLayer.*;

/**
 * Hello world!
 *
 */
public class App 
{
	
	public static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	public static ControllerLayer controllerLayer = new ControllerLayer();
	
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
        
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        ControllerLayer.userMenu();
        
        
        session.close();
    }
}
