package com.kshitij.web;

import com.fasterxml.jackson.annotation.JsonProperty;

public class States {

	private String name;
	private String abbreviation;
	private String capital;
	@JsonProperty("most-populous-city")
	private String mostPopulousCity;
	private String population;
	@JsonProperty("square-miles")
	private String squareMiles;
	@JsonProperty("time-zone-1")
	private String timeZone1;
	@JsonProperty("time-zone-2")
	private String timeZone2;
	private String dst;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getMostPopulousCity() {
		return mostPopulousCity;
	}
	public void setMostPopulousCity(String mostPopulousCity) {
		this.mostPopulousCity = mostPopulousCity;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	public String getSquareMiles() {
		return squareMiles;
	}
	public void setSquareMiles(String squareMiles) {
		this.squareMiles = squareMiles;
	}
	public String getTimeZone1() {
		return timeZone1;
	}
	public void setTimeZone1(String timeZone1) {
		this.timeZone1 = timeZone1;
	}
	public String getTimeZone2() {
		return timeZone2;
	}
	public void setTimeZone2(String timeZone2) {
		this.timeZone2 = timeZone2;
	}
	public String getDst() {
		return dst;
	}
	public void setDst(String dst) {
		this.dst = dst;
	}
	
	
}
