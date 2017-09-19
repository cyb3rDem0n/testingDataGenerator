package it.senseisrl.mitiga.survey;

public class Country{
	
	int id;
	String countryName;	
	long population;
	
	public Country() {
	}
	public Country(int i, String countryName,long population) {
		this.id = i;
		this.countryName = countryName;
		this.population=population;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}	
	
}