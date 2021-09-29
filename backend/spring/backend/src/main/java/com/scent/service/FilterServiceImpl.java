package com.scent.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.scent.entity.Perfume;
import com.scent.repo.ListOnlySeasonRepo;
import com.scent.repo.FilterRepo;

@Service
public class FilterServiceImpl implements FilterService {

	@Autowired
	FilterRepo filterRepo;

	@Autowired
	ListOnlySeasonRepo onlySeasonRepo;

	@Override
	public List<Perfume> findPerfumeTitle(String title) {
		List<Perfume> list = filterRepo.findByTitleContaining(title);
		return list;

	}

	@Override
	public List<Perfume> findPerfumeId(List<Integer> idList) {
		List<Perfume> list = new ArrayList<Perfume>();
		for (int i = 0; i < idList.size(); i++) {
			Optional<Perfume> perfume = filterRepo.findById(idList.get(i));
			System.out.println("나다1");
			list.add(perfume.get());
			System.out.println("나다2");
		}
		return list;

	}

	@Override
	public List<Perfume> findSeason(String season) {

		List<Perfume> list = onlySeasonRepo.findBySeason(season);
		return list;

	}

	@Override
	public List<Perfume> findDayNight(String daynight) {
		int daynightInt = Integer.parseInt(daynight);
		List<Perfume> list = filterRepo.findByDaynight(daynightInt);
		return list;

	}

	@Override
	public List<Perfume> findGender(String gender) {
		List<Perfume> list = filterRepo.findByGender(gender);
		return list;

	}

}
