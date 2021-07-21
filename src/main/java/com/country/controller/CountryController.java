package com.country.controller;

import java.util.List;
import java.util.logging.LogManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.country.bean.Country;
import com.country.service.CountryService;

import ch.qos.logback.classic.Logger;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value="country")
@Slf4j
public class CountryController {
	
	
	@Autowired
	private CountryService countryService;
	public CountryController() {
		countryService = new CountryService();
		
	}
	
	@GetMapping(value="/countries", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Country> getAllCountries(){
		log.info("Inside getAllCountries");
		log.debug("debug");
		return countryService.getAllCountries();
	}
	
	@ApiOperation(value = "Finds country by id",
			notes = "Provide an id to look up specifc country details",
			response = Country.class)
	@GetMapping(value="/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Country getCountryById(@ApiParam(value = "ID value for the country we need to retrieve", required=true)@PathVariable("id") int id) {
		return countryService.getCountry(id);
	}
	
	@PostMapping(value="/newcountry", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity addCountry(@RequestBody Country country)
	{
		boolean flag=countryService.addCountry(country);
		if(flag==true) {
		return new ResponseEntity(country, HttpStatus.CREATED);
		}
		return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
	}

}
