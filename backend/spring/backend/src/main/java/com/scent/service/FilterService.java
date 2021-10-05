package com.scent.service;

import java.util.List;

import com.scent.entity.Perfume;

public interface FilterService {

	List<Perfume> findChecked(String season, String daynight, String gender);

	List<Perfume> findPerfumeTitle(String title);
	
	List<Perfume> findPerfumeBrand(String brand);

	List<Perfume> showAllList();
	
	List<Perfume> findGrace();

}
