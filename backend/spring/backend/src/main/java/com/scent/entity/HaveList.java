package com.scent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "userhave")
@DynamicInsert
@DynamicUpdate
public class HaveList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	@ManyToOne
//	@JoinColumn(name = "perfume_id", insertable = false, updatable = false)
//	@Column(nullable = false)
//	private Perfume perfume;
	
	@Column(nullable = false, updatable = false)
	private int perfume_id;
	
//	@ManyToOne
//	@JoinColumn(name = "user_id", insertable = false, updatable = false)
//	private User user;
	@Column(nullable = false, updatable = false)
	private int user_id;
	
	@Column(nullable = true, updatable = true, length = 100)
	private String review;
	
	@Column(nullable = true, updatable = true, columnDefinition = "float default 0.0")
	private float score;
	
	public void insertRev(String review, float score) {
		this.review = review;
		this.score = score;
	}
}
