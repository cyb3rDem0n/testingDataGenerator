package it.senseisrl.mitiga.survey.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import it.senseisrl.mitiga.survey.Country;

public class CountryService {

	static HashMap<Integer,Country> countryIdMap=getCountryIdMap();


	public CountryService() {
		super();

		if(countryIdMap==null)
		{
			countryIdMap=new HashMap<Integer,Country>();
			Country indiaCountry=new Country(1, "a",11111);
			Country chinaCountry=new Country(4, "b",2222);
			Country nepalCountry=new Country(3, "c",3333);
			Country bhutanCountry=new Country(2, "d",4444);


			countryIdMap.put(1,indiaCountry);
			countryIdMap.put(4,chinaCountry);
			countryIdMap.put(3,nepalCountry);
			countryIdMap.put(2,bhutanCountry);
		}
	}

	public List<Country> getAllCountries()
	{
		List<Country> countries = new ArrayList<Country>(countryIdMap.values());
		return countries;
	}

	public Country getCountry(int id)
	{
		Country country= countryIdMap.get(id);
		return country;
	}
	public Country addCountry(Country country)
	{
		country.setId(countryIdMap.size()+1);
		countryIdMap.put(country.getId(), country);
		return country;
	}
	
	public Country updateCountry(Country country)
	{
		if(country.getId()<=0)
			return null;
		countryIdMap.put(country.getId(), country);
		return country;

	}
	public void deleteCountry(int id)
	{
		countryIdMap.remove(id);
	}

	public static HashMap<Integer, Country> getCountryIdMap() {
		return countryIdMap;
	}


}
