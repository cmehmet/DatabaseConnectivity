package hibernateDemoRecap;

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
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//SELECT
//			List<City> cities = session.createQuery("from City").getResultList();			
//			for(City city :cities) {
//				System.out.println(city.getName());
//			}
			
			// INSERT
//			City city = new City();
//			city.setName("Adana3");
//			city.setCountryCode("TUR");
//			city.setDistrict("Akdeniz");
//			city.setPopulation(1500000);
//		
//			session.save(city);
			
			//UPDATE
//			City city = session.get(City.class, 4092);
//			city.setPopulation(1700000);
//			session.save(city2);
			
			//DELETE
			City city = session.get(City.class, 4092);
			session.delete(city);
		
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}

	}

}
