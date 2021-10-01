package com.scent.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.scent.entity.Perfume;
import com.scent.entity.QPerfume;
import com.scent.repo.FilterRepo;
import com.scent.repo.ListOnlySeasonRepo;

@Service
public class FilterServiceImpl implements FilterService {

	@Autowired
	private FilterRepo filterRepo;

	@PersistenceContext // 영속성 객체를 자동으로 삽입해줌
	private EntityManager em;

	@Override
	public List<Perfume> findChecked(String season, String daynight, String gender) {
		JPAQueryFactory queryFactory = new JPAQueryFactory(em);
		QPerfume perfume = QPerfume.perfume;
		List<Perfume> list = queryFactory.selectFrom(perfume)
				.where(perfume.season.eq(season), perfume.daynight.eq(daynight), perfume.gender.eq(gender)).fetch();
		return list;
	}

	@Override
	public List<Perfume> findPerfumeTitle(String title) {
		List<Perfume> list = filterRepo.findByTitle(title);
		return list;

	}

}
