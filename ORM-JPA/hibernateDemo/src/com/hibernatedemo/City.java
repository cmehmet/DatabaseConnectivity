package com.hibernatedemo;

import javax.persistence.Entity;
import javax.management.ConstructorParameters;
import javax.persistence.*;



@Entity
@Table(name = "city")
public class City {
	
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "CountryCode")
	private String countryCode;
	
	@Column(name = "District")
	private String district;
	
	@Column(name = "Population")
	private int population;
	
	
	public City(String name,String countryCode,String district,int population) {
		this.name=name;
		this.countryCode=countryCode;
		this.district=district;
		this.population=population;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getDistrtict() {
		return district;
	}
	public void setDistrtict(String distrtict) {
		this.district = distrtict;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	
	
}
