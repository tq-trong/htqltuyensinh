package com.cusc.htqltuyensinh.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "provinces")
public class ProvinceEntity extends BaseEntity{
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "province")
    private List<SchoolEntity> schools = new ArrayList<>();
	
	@OneToMany(mappedBy = "province")
    private List<UserEntity> users = new ArrayList<>();
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SchoolEntity> getSchools() {
		return schools;
	}

	public void setSchools(List<SchoolEntity> schools) {
		this.schools = schools;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
}
