package com.scent.service;

import java.util.Optional;

import com.scent.entity.User;

public interface UserService {
	Optional<User> login(User user); // 로그인
	int insertUser(User user); // 회원가입
	Optional<User> getUser(String user_id); // 회원정보 조회
	int updateUser(String user_id, String password, String nickname); // 회원정보 수정
	int deleteUser(String user_id); // 회원탈퇴
}
