package com.scent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Transient;

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
@Entity(name = "userlike")
@SecondaryTable(name = "perfume", pkJoinColumns = @PrimaryKeyJoinColumn(name = "perfume_id"))
@DynamicInsert
@DynamicUpdate
public class WantList {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
//		@ManyToOne
//		@JoinColumn(name = "perfume_id")
//		private Perfume perfume;
		
//		@ManyToOne
//		@JoinColumn(name = "user_id")
//		private User user;
		
		@Column(nullable = false, updatable = false)
		private int user_id;
		
		@Column(nullable = false, updatable = false)
		private int perfume_id;
		
		@Column(table = "perfume")
		private String title;
}
