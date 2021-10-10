package com.scent.service;

import java.util.List;

import com.scent.entity.WantList;

public interface WantService {
	List<WantList> getAll();
	List<WantList> getList(int user_id); // 해당 유저의 좋아요 목록
	int insertList(WantList wlist); // 좋아요 등록
	int delete(int id); // 좋아요 취소
}
