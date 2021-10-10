package com.scent.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.scent.entity.User;

@Repository
//public interface UserRepository {
public interface UserRepository extends JpaRepository<User, Integer>{
	// DB에 회원 정보가 저장되어있고, 그에 대한 접근을 repository에서
	
	@Query("select u from user u where u.user_id = :user_id")
	Optional<User> findById(String user_id); // 회원정보 조회
	
	@Query("select u from user u where u.nickname = :nickname")
	Optional<User> findByNick(String nickname); // 닉네임 중복 체크
}
