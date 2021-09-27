package com.scent.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scent.entity.User;

@Repository
//public interface UserRepository {
public interface UserRepository extends JpaRepository<User, String>{
	// DB에 회원 정보가 저장되어있고, 그에 대한 접근을 repository에서
//	User getUser(String user_id); // 회원정보 조회
//	void updateUser(User user); // 회원정보 수정
//	void deleteUser(String user_id); // 회원탈퇴
}
