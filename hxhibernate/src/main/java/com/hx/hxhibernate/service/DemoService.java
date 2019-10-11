package com.hx.hxhibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hx.hxhibernate.entity.DemoEntity;
import com.hx.hxhibernate.repository.DemoRepository;

@Service
public class DemoService {
	@Autowired
	DemoRepository drep;

	public DemoEntity findById(String id) {
		return drep.findById(id);
	}

	public DemoEntity save(DemoEntity user) {
		return drep.save(user);
	}

	public DemoEntity findName(String name) {
		return drep.findName(name);
	}

}
