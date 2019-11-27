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
	UserRepository urep;

	@Override
	public void save(UserEntity user) {
		urep.save(user);
	}

	@Override
	public UserEntity findById(String id) {
		return urep.findById(id);
	}

	@Override
	public ArrayList<UserEntity> listDatas() {
		return (ArrayList<UserEntity>) urep.findAll();
	}

	@Override
	public int getTotalCount() {
		return (int) urep.count();
	}

	@Override
	public void update(UserEntity user) {
		UserEntity oldUser = findById(user.getId());
		if (oldUser != null) {
			oldUser.setCaption(user.getCaption());
			oldUser.setPassword(user.getPassword());
			urep.save(oldUser);
		}
	}

	@Override
	public void deleteById(String id) {
		urep.delete(findById(id));
	}

}
