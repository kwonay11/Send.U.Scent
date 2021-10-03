package com.scent.repo;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.scent.entity.QPerfume;

public class PerfumePredicate {

	public static Predicate search(String season, String daynight, String gender) {

		QPerfume perfume = QPerfume.perfume;

		BooleanBuilder builder = new BooleanBuilder();

		if (season != null) {
			builder.and(perfume.season.eq(season));
		}
		if (daynight != null) {
			builder.and(perfume.daynight.eq(daynight));
		}
		if (gender != null) {
			builder.and(perfume.gender.eq(gender));
		}

		return builder;
	}
}
