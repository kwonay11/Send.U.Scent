package com.scent.service;

import java.util.List;

import com.scent.entity.Perfume;

public interface ListService {
	List<Perfume> findPerfumeTitle(String title);
}
