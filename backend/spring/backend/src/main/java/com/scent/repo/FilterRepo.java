package com.scent.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.scent.entity.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FilterRepo extends JpaRepository<Perfume, Integer> {
	List<Perfume> findByTitleContaining(String title);
	List<Perfume> findByDaynight(int daynight);
	List<Perfume> findByGender(String gender);
	Optional<Perfume> findById(Integer id);
}
