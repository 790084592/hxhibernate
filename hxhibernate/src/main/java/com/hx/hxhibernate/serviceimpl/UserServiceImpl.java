package com.hx.hxhibernate.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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
	public List<UserEntity> listDatas() {
		return urep.findAll();
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

	@Override
	public List<UserEntity> selectPlayer(UserEntity user, Pageable pageable) {
		Specification<UserEntity> query = new Specification<UserEntity>() {
			/**
			 * 序列化id
			 */
			private static final long serialVersionUID = -6554077526281828131L;

			@Override
			public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery,
					CriteriaBuilder criteriaBuilder) {
				ArrayList<Predicate> predicates = new ArrayList<>();
				if (user != null) {
					if (user.getCaption() != null) {
						predicates.add(criteriaBuilder.like(root.get("caption"), "%" + user.getCaption() + "%"));
					}
				}
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
		return urep.findAll(query, pageable).getContent();
	}

}
