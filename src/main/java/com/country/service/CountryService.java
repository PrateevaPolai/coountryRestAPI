package com.country.service;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.country.bean.Country;

@Service
public class CountryService {
	
	public static List<Country> countryIdMap;
	public CountryService() {
		
		Country indiaCountry=new Country(1, "India",10000);
        Country bhutanCountry=new Country(2, "Bhutan",7000);
        Country nepalCountry=new Country(3, "Nepal",8000);
        Country chinaCountry=new Country(4, "China",20000);
		countryIdMap=new ArrayList<Country>();
		
         countryIdMap.add(indiaCountry);
         countryIdMap.add(bhutanCountry);
         countryIdMap.add(nepalCountry);
         countryIdMap.add(chinaCountry);
		
	 }
 
    public List<Country> getAllCountries()
    {
        return countryIdMap;
    }
 
    public Country getCountry(int id)
    {
        Country country= countryIdMap.stream().filter(x->x.getId()==id).findFirst().get();
        return country;
    }
    
    public boolean addCountry(Country country)
    {
    	countryIdMap.add(country);
    	return true;
    }
//    public Country addCountry(Country country)
//    {
//        country.setId(getMaxId()+1);
//        countryIdMap.put(country.getId(), country);
//        return country;
//    }
// 
//    public Country updateCountry(Country country)
//    {
//        if(country.getId()<=0)
//            return null;
//        countryIdMap.put(country.getId(), country);
//        return country;
// 
//    }
//    public void deleteCountry(int id)
//    {
//        countryIdMap.remove(id);
//    }
// 
//    public static HashMap<Integer, Country> getCountryIdMap() {
//        return countryIdMap;
//    }
 
    // Utility method to get max id
//    public static int getMaxId()
//    { int max=0;
//    for (int id:countryIdMap.keySet()) { 
//        if(max<=id)
//            max=id;
// 
//    } 
//    return max;
//    }
}