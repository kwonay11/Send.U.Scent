package com.scent.list.service;

import com.scent.entity.*;

public interface UserService {
	User getUser(String user_id); // 회원정보 조회
	void updateUser(User user); // 회원정보 수정
	void deleteUser(String user_id); // 회원탈퇴
}
