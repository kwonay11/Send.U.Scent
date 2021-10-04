package com.scent.service;

import java.util.List;
import java.util.Optional;

import com.scent.entity.HaveList;

public interface HaveService {
	List<HaveList> getAll();
	List<HaveList> getList(int user_id); // user_id 의 가지고 있는 향수목록 조회
	int insertList(HaveList hlist); // 가지고 있는 목록 추가
	int insertRev(int id, String review, float score); // 해당 목록의 perfume에 대한 리뷰와 평점 등록
	int deleteList(int id); // 해당 목록 삭제
	int deleteRev(int id); // 해당 향수 리뷰 삭제
}
