package com.hx.hxhibernate.service;

import java.util.ArrayList;

import com.hx.hxhibernate.entity.UserEntity;

public interface UserService {

	public UserEntity findById(String id);

	public ArrayList<UserEntity> listDatas();

	public int getTotalCount();

	public void save(UserEntity user);
	
	public void update(UserEntity user);
	
	public void deleteById(String id);
	
}
