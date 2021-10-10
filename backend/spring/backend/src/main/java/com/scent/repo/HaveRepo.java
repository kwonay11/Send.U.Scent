package com.scent.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.scent.entity.HaveList;

@Repository
public interface HaveRepo extends JpaRepository<HaveList, Integer>{
	
	@Query(value = "select u.id, u.perfume_id, p.title, u.user_id, u.review, u.score from userhave u join perfume p on u.perfume_id = p.perfume_id where user_id = ?", nativeQuery = true)
	List<HaveList> findByUserId(int user_id); // 해당 id의 유저가 쓴 목록 조회
	
	@Query(value = "select * from userhave where user_id = ? and perfume_id = ?", nativeQuery = true)
	Optional<HaveList> findByPerfume(int user_id, int perfume_id);

	@Modifying
	@Query(value = "delete from userhave where id = ?", nativeQuery = true)
	void deleteById(int id);
}
