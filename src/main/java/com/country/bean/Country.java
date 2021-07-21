package com.country.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about the Country")
public class Country {
	@ApiModelProperty(notes = "The uniue ID of the country")
	int id;
	@ApiModelProperty(notes = "Countries name")
	String countryName;
	@ApiModelProperty(notes = "Countries populations")
	long population;
	
	public Country() {
		super();
	}

	public Country(int id, String countryName, long population) {
		super();
		this.id=id;
		this.countryName=countryName;
		this.population=population;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getCountryName() {
		return countryName;
	}
	
	public void setCountryName(String countryName) {
		this.countryName=countryName;
	}
	
	public long getPopulation() {
		return population;
	}
	
	public void setPopulation(long population) {
		this.population=population;
	}
	
}
