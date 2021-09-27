package com.scent.entity;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;

import lombok.*;

@Getter // lombok getter
@Builder // = 생성자
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="user") // JPA를 사용할 클래스명 명시, 테이블과 매핑
public class User {
	@Id // 기본키 설정
	@Column(length = 20)
	private String user_id;
	
	@Column(nullable = false, length = 30)
	private String password;
	
	@Column(nullable = false, unique = true, length = 20)
	private String nickname;
	
	@Column(nullable = true)
	@ColumnDefault("false")
	private boolean admin;
	
}
