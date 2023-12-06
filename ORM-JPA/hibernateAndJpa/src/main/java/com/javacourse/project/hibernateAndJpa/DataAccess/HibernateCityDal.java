package com.javacourse.project.hibernateAndJpa.DataAccess;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javacourse.project.hibernateAndJpa.Entities.City;

import jakarta.persistence.EntityManager;


//JPA - ORM , JPA ilk etapta veri erişim tekniği olarak ortaya çıkmış(ORM gibi).Daha sonra,JAVA da bir standart haline geliyor.
//Hibernate kullanırken sessionfactory kullanmıştık. Bunun standartlaştırılmış versiyonu JPA oluyor.
//Aslında hibernate ve spring JPA' yı implemente ediyor. Dolayısıyla JPA'yı kullanarak hibernate ile de yapabiliriz diğeriyle de.
//JPA ile, hibernate dersindeki SessionFactory ve session nesnesini "ConstructorInjection" ile otomatik oluşturacağız.

//AOP - Aspect Oriented Programming--> Code Build olduğunda önüne ve arkasına transaction koyuyor (@Transactional) ve işleri kolaylaştırıyor.
//Hibernate dersindeki "unit of work" tasarım deseni(@Transactional).

@Repository
public class HibernateCityDal implements ICityDal{
	
	private EntityManager entityManager;  //SessionFactory ve session nesnesini bu şekilde yönetiyoruz.
	
	@Autowired //Springframework'de entitiyManager'ın implementasyonunu inceleyecek ve bizim hibernate'i kullandığımızı görüp otomatik olarak onun injection işlemini yapacak.
	public HibernateCityDal(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	
	@Override
	@Transactional 
	public List<City> getAll() {
		Session session = entityManager.unwrap(Session.class);//JPA'dan hibernate için session istedik.
		List<City> cities = session.createQuery("from City",City.class).getResultList();
		return cities;
	}

	@Override
	@Transactional
	public void add(City city) {
		Session session = entityManager.unwrap(Session.class);
		session.merge(city);
		
	}

	@Override
	public void update(City city) {
		Session session = entityManager.unwrap(Session.class);
		session.merge(city);
		
	}

	@Override
	public void delete(City city) {
		Session session = entityManager.unwrap(Session.class);
		City cityToDelete = session.get(City.class,city.getId());
		session.remove(cityToDelete);
		
	}

	@Override
	public City getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		City city = session.get(City.class,id);
		return city;
	}

}
