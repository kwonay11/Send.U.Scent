package com.scent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scent.entity.WantList;
import com.scent.repo.WantRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WantServiceImpl implements WantService{

	private final WantRepo wantRepo;
	
	@Override // 전체 목록
	public List<WantList> getAll() {
		return wantRepo.findAll();
	}

	@Override // 해당 유저의 좋아요 목록
	public List<WantList> getList(int user_id) {
		List<WantList> wl = wantRepo.findByUserId(user_id);
		return wl;
	}

	@Override // 좋아요 취소 = 목록 삭제
	public int delete(int id) {
		Optional<WantList> oWl = wantRepo.findById(id);
		if(oWl.isPresent()) {
			wantRepo.deleteById(id);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertList(WantList wlist) {
		Optional<WantList> oWl = wantRepo.findByPerfume(wlist.getUser_id(), wlist.getPerfume_id());
		if(!oWl.isPresent()) {
			wantRepo.save(wlist);
			return 1;
		}
		return 0;
	}
	
	
}
