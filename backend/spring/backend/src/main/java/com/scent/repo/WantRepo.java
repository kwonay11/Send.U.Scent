package com.scent.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.scent.entity.WantList;

@Repository
public interface WantRepo extends JpaRepository<WantList, Integer>{
		
		@Query(value = "select u.id, u.perfume_id, p.title, u.user_id from perfume p join userlike u on p.perfume_id = u.perfume_id where u.user_id = ?", nativeQuery = true)
		List<WantList> findByUserId(int user_id); // 해당 유저의 좋아요 목록

		@Query(value = "select * from userlike where user_id = ? and perfume_id = ?", nativeQuery = true)
		Optional<WantList> findByPerfume(int user_id, int perfume_id);
		
		@Modifying
		@Query(value = "delete from userlike where id = ?", nativeQuery = true)
		void deleteById(int id);
}
