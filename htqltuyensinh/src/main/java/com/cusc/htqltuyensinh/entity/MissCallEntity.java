package com.cusc.htqltuyensinh.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "miss_calls")
public class MissCallEntity extends BaseEntity{
	
	@ManyToOne
	@JoinColumn(name = "users_id")
    private UserEntity user;
	
	@Column(name = "time")
	private Date time;

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
