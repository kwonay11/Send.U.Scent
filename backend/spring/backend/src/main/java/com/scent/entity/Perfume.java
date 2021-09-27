package com.scent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "perfume")
public class Perfume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "perfume_id")
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "brand")
	private String brand;

	@Column(name = "accords")
	private String accords;

	@Column(name = "gender")
	private String gender;

	@Column(name = "longevity")
	private String longevity;

	@Column(name = "sillage")
	private int sillage;

	@Column(name = "daynight")
	private int daynight;

	@Column(name = "top")
	private String top;

	@Column(name = "middle")
	private String middle;

	@Column(name = "base")
	private String base;

	@Column(name = "rating_score")
	private float rating_score;

	@Column(name = "votes")
	private int votes;

}
