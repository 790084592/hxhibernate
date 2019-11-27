package com.hx.hxhibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hx.hxhibernate.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	public UserEntity save(UserEntity user);

	@Query(value = "SELECT u FROM UserEntity u WHERE id=:id")
	public UserEntity findById(@Param("id") String id);

}
