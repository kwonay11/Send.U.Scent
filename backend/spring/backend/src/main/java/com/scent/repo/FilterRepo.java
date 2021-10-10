package com.scent.repo;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.scent.entity.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

@Repository
public interface FilterRepo extends JpaRepository<Perfume, Integer>,QuerydslPredicateExecutor<Perfume> {
	List<Perfume> findByTitleContaining(String title);
	List<Perfume> findByBrandContaining(String brand);
	List<Perfume> findTop1000ByOrderByRatingscoreDesc();
	List<Perfume> findById(int id);
}
