package com.hx.hxhibernate.serviceimpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hx.hxhibernate.entity.UserEntity;
import com.hx.hxhibernate.repository.UserRepository;
import com.hx.hxhibernate.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository drep;

	@Override
	public void save(UserEntity user) {
		drep.save(user);
	}

	@Override
	public UserEntity findById(String id) {
		return drep.findById(id);
	}

	@Override
	public ArrayList<UserEntity> listDatas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalCount() {
		return (int) drep.count();
	}

	@Override
	public void modify(UserEntity user) {
		UserEntity oldUser = findById(user.getId());
		if(oldUser == null) {
			drep.save(oldUser);
		}
	}

	@Override
	public void deleteById(String id) {
		drep.delete(findById(id));
	}

}
