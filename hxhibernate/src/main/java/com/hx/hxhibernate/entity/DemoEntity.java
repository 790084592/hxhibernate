package com.hx.hxhibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "yyh_user")
public class DemoEntity extends BaseEntity {
	@Column(name = "caption")
	public String caption;

	public DemoEntity() {

	}
	
	public DemoEntity(String id, String name, String caption) {
		this.id = id;
		this.name = name;
		this.caption = caption;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}
}