package com.hx.hxhibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hxcloudpan_login_user_003")
public class UserEntity extends BaseEntity {

	private static final long serialVersionUID = -2791257324701858323L;

	@Column(name = "caption_")
	public String caption;

	@Column(name = "password_")
	public String password;

	public UserEntity() {

	}

	public UserEntity(String id, String caption, String password) {
		this.id = id;
		this.caption = caption;
		this.password = password;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}