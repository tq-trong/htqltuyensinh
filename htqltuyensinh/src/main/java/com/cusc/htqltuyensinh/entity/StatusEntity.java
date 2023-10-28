package com.cusc.htqltuyensinh.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class StatusEntity extends BaseEntity{

	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "status")
    private List<CallEntity> calls = new ArrayList<>();
	
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

	public List<CallEntity> getCalls() {
		return calls;
	}

	public void setCalls(List<CallEntity> calls) {
		this.calls = calls;
	}
}
