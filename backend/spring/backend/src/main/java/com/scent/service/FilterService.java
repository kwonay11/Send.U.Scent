package com.scent.service;

import java.util.List;

import com.scent.entity.Perfume;

public interface FilterService {
	List<Perfume> findPerfumeTitle(String title);

	List<Perfume> findSeason(String season);

	List<Perfume> findDayNight(String option);

	List<Perfume> findGender(String gender);

	List<Perfume> findPerfumeId(List<Integer> id);
}
