package com.scent.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.scent.entity.Perfume;

public interface ListRepo extends JpaRepository<Perfume, Integer>  {
	List<Perfume> findByTitleContaining(String title);
}
