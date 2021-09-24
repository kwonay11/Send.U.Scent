package com.scent.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.scent.entity.*;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
}
