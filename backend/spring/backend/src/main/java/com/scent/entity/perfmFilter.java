package com.scent.entity;

public class perfmFilter {
	String season;
	String gender;
	String daynight;

	public perfmFilter(String season, String gender, String daynight) {
		super();
		this.season = season;
		this.gender = gender;
		this.daynight = daynight;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDaynight() {
		return daynight;
	}

	public void setDaynight(String daynight) {
		this.daynight = daynight;
	}

}
