package com.scent.service;

import java.util.Optional;

import com.scent.entity.User;

public interface UserService {
	Optional<User> login(User user); // 로그인
	int insertUser(User user); // 회원가입
	Optional<User> getUser(String user_id); // 회원정보 조회
	int updateUser(String user_id, String password, String nickname); // 회원정보 수정
	int updateRes(String user_id, String accord1, String accord2, String accord3, String accord4, String accord5, Integer longevity, Integer silage, String season); // 테스트 결과 갱신
	int deleteUser(String user_id); // 회원탈퇴
	Optional<User> getUserNick(String nickname); // 닉네임 중복 체크
}
