package com.scent.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;

import lombok.*;

@Getter // lombok getter
@Builder // = 생성자
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "user") // JPA를 사용할 클래스명 명시, 테이블과 매핑
@DynamicUpdate // 변경된 필드만 적용
public class User {
	@Id // 기본키 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, unique = true, updatable = true, length = 20)
	private String user_id;

	@Column(nullable = false, updatable = true, length = 30)
	private String password;

	@Column(nullable = false, unique = true, updatable = true, length = 20)
	private String nickname;

	@Column(nullable = true, updatable = false)
	@ColumnDefault("false")
	private boolean admin;

	@Column(nullable = true, updatable = true, length = 20)
	private String accord1;
	
	@Column(nullable = true, updatable = true, length = 20)
	private String accord2;
	
	@Column(nullable = true, updatable = true, length = 20)
	private String accord3;
	
	@Column(nullable = true, updatable = true, length = 20)
	private String accord4;
	
	@Column(nullable = true, updatable = true, length = 20)
	private String accord5;
	
	@Column(nullable = true, updatable = true)
	private Integer longevity;
	
	@Column(nullable = true, updatable = true)
	private Integer silage;
	
	@Column(nullable = true, updatable = true, length = 20)
	private String season;
	
//	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
//	private List<HaveList> havelist = new ArrayList<HaveList>();

	public void update(String password, String nickname) {
		this.password = password;
		this.nickname = nickname;
	}
	
	public void updateRes(String user_id, String accord1, String accord2, String accord3, String accord4, String accord5, Integer longevity, Integer silage, String season) {
		this.user_id = user_id;
		this.accord1 = accord1;
		this.accord2 = accord2;
		this.accord3 = accord3;
		this.accord4 = accord4;
		this.accord5 = accord5;
		this.longevity = longevity;
		this.silage = silage;
		this.season = season;
	}

}
