package com.scent.entity;

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
	@Column(length = 20, updatable = false)
	private String user_id;

	@Column(nullable = false, updatable = true, length = 30)
	private String password;

	@Column(nullable = false, unique = true, updatable = true, length = 20)
	private String nickname;

	@Column(nullable = true, updatable = false)
	@ColumnDefault("false")
	private boolean admin;
	
	public void update(String password, String nickname) {
		this.password = password;
		this.nickname = nickname;
	}

}
