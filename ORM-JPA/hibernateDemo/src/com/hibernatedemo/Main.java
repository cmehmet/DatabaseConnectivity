package com.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(City.class)
				.buildSessionFactory();
		
		// sesssion da aslında "unit of work design pattern" otomatik olarak kullanılıyor. 
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			// HQL--> Hibernate Query Language
			// select * from city  ---> from city
			// from City c where c.countryCode = 'TUR' AND c.district = 'Istanbul'
			// from City c where c.countryCode = 'TUR' AND c.name Like '%tan%'
			// from City c where c.countryCode = 'TUR' AND c.name Like 'A%'
			// from City c Order By c.name
			// from City c ORDER BY c.name DESC
			// select c.countryCode from City c GROUP BY c.countryCode
			// select c.countryCode from City c where c.countryCode Like 'A%' GROUP BY c.countryCode
			
			// SELECT 
			List<String> countryCodes = session.createQuery("select c.countryCode from City c GROUP BY c.countryCode").getResultList();
			
			for(String countryCode : countryCodes) {
				System.out.println(countryCode);
			}
			
			
			// INSERT
			/*City city = new City("Adana 2","TUR","Akdeniz",2000000);
			session.save(city);*/
			
			// UPDATE
			/*City city = session.get(City.class, 4091);
			//System.out.println(city.getName());
			city.setPopulation(2500000);
			session.save(city);
			*/
			
			// DELETE
			
			//City city = session.get(City.class, 4091);
			//session.delete(city);
			
			
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
