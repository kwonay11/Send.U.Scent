package com.scent.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scent.entity.User;
import com.scent.service.UserService;
import com.scent.repo.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 의존성 주입
public class UserServiceImpl implements UserService {

	private final UserRepository userRepo;
	
	@Override
	public Optional<User> login(User user) {
		Optional<User> oUser = userRepo.findById(user.getUser_id());
		if(!oUser.isPresent() && user.getPassword() == oUser.get().getPassword()) {
			return oUser;
		}
		return null;
	}

	@Override // 회원 가입
	public int insertUser(User user) {
		Optional<User> oUser = userRepo.findById(user.getUser_id());
		if(!oUser.isPresent()) {
			userRepo.save(user);
			return 1;
		}
		return 0;
	}
	
	@Override // 회원 정보 조회
	public Optional<User> getUser(String user_id) {
		Optional<User> user = userRepo.findById(user_id);
		return user;
	}

	@Override // 회원 정보 수정
	public int updateUser(String user_id, String password, String nickname) {
		Optional<User> oUser = userRepo.findById(user_id);
		if(oUser.isPresent()) {
			User user = oUser.get(); 
			user.update(password, nickname);
			userRepo.save(user);
			return 1;
		}
		return 0;
	}

	@Override // 회원 탈퇴
	public int deleteUser(String user_id) {
		Optional<User> user = userRepo.findById(user_id);
		if(user.isPresent()) {
			userRepo.delete(user.get());
			return 1;
		}
		return 0;
	}

	@Override // 테스트 결과 갱신
	public int updateRes(String user_id, String accord1, String accord2, String accord3, String accord4, String accord5,
			Integer longevity, Integer silage, String season) {
		Optional<User> oUser = userRepo.findById(user_id);
		if(oUser.isPresent()) {
			User user = oUser.get(); 
			user.updateRes(user_id, accord1, accord2, accord3, accord4, accord5, longevity, silage, season);
			userRepo.save(user);
			return 1;
		}
		return 0;
	}

	@Override // 닉네임 중복 체크
	public Optional<User> getUserNick(String nickname) {
		Optional<User> user = userRepo.findByNick(nickname);
		return user;
	}

}
