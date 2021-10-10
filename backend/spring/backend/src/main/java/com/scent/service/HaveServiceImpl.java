package com.scent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scent.entity.HaveList;
import com.scent.repo.HaveRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HaveServiceImpl implements HaveService{

	private final HaveRepo haveRepo;
	
	@Override // 전체 목록 조회
	public List<HaveList> getAll() {
		return haveRepo.findAll();
	}

	@Override // 해당 유저의 목록 조회
	public List<HaveList> getList(int user_id) {
		List<HaveList> oHl = haveRepo.findByUserId(user_id);
		return oHl;
	}
	
	@Override // 목록 추가
	public int insertList(HaveList hlist) {
		Optional<HaveList> oHl = haveRepo.findByPerfume(hlist.getUser_id(), hlist.getPerfume_id());
		if(!oHl.isPresent()) {
			haveRepo.save(hlist);
			return 1;
		}
		return 0;
	}

	@Override // 리뷰 등록
	public int insertRev(int id, String review, float score) {
		Optional<HaveList> oHl = haveRepo.findById(id);
		if(oHl.isPresent()) {
			HaveList hl = oHl.get();
			if(hl.getReview() == null) {
				hl.insertRev(review, score);
				haveRepo.save(hl);
				return 1;
			}
		}
		return 0;
	}

	@Override // 목록 삭제
	public int deleteList(int id) {
		Optional<HaveList> oHl = haveRepo.findById(id);
		if(oHl.isPresent()) {
			haveRepo.deleteById(id);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteRev(int id) {
		Optional<HaveList> oHl = haveRepo.findById(id);
		if(oHl.isPresent()) {
			HaveList hl = oHl.get();
			if(hl.getReview() != null) {
				hl.insertRev(null, 0);
				haveRepo.save(hl);
				return 1;
			}
		}
		return 0;
	}

	

}
