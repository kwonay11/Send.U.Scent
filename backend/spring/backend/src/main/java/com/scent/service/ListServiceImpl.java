package com.scent.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.scent.entity.Perfume;
import com.scent.repo.ListRepo;

@Service
public class ListServiceImpl implements ListService {

	@Autowired
	ListRepo listRepo;
	
	@Override
	public List<Perfume> findPerfumeTitle(String title) {
		List<Perfume> list = listRepo.findByTitleContaining(title);
		return list;

	}

}
