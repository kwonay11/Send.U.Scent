package com.scent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	@Column(nullable = false)
	private int perfume_id;
	
	@Column(nullable = false)
	private int user_id;
	
	@Column(nullable = true, updatable = true, length = 100)
	private String review;
	
	@Column(nullable = true, updatable = true, columnDefinition = "float default 0.0")
	private float score;
}
