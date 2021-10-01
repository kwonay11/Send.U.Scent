package com.scent.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.scent.entity.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

@Repository
public interface FilterRepo extends JpaRepository<Perfume, Integer>,QuerydslPredicateExecutor<Perfume> {
	List<Perfume> findByTitle(String title);
}
