package com.hx.hxhibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 所有实体的基类
 * 
 * @author xush
 * @since 2019年10月11日
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -2412046011446204120L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public String id;

	@Column(name = "name")
	public String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}