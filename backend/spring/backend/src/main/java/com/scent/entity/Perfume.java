package com.scent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
//@Builder
@Getter
//@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "filter_perfm")
public class Perfume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "filter_perfume_id")
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "brand")
	private String brand;

	@Column(name = "accords")
	private String accords;

	@Column(name = "season")
	private String season;

	@Column(name = "gender")
	private String gender;

	@Column(name = "longevity")
	private String longevity;

	@Column(name = "sillage")
	private int sillage;

	@Column(name = "daynight")
	private String daynight;

	@Column(name = "top")
	private String top;

	@Column(name = "middle")
	private String middle;

	@Column(name = "base")
	private String base;

	@Column(name = "rating_score")
	private float ratingscore;

	@Column(name = "votes")
	private int votes;

	public Perfume(int id, String title, String brand, String accords, String season, String gender, String longevity,
			int sillage, String daynight, String top, String middle, String base, float ratingscore, int votes) {
		this.id = id;
		this.title = title;
		this.brand = brand;
		this.accords = accords;
		this.season = season;
		this.gender = gender;
		this.longevity = longevity;
		this.sillage = sillage;
		this.daynight = daynight;
		this.top = top;
		this.middle = middle;
		this.base = base;
		this.ratingscore = ratingscore;
		this.votes = votes;
	}

}
