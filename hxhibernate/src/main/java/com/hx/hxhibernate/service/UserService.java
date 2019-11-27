package com.hx.hxhibernate.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.hx.hxhibernate.entity.UserEntity;

public interface UserService {

	public UserEntity findById(String id);

	public List<UserEntity> listDatas();

	public int getTotalCount();

	public void save(UserEntity user);

	public void update(UserEntity user);

	public void deleteById(String id);

	public List<UserEntity> selectPlayer(UserEntity user, Pageable pageable);

}
