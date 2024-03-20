package com.cusc.htqltuyensinh.dto;

public class AssignDetailDTO extends BaseDTO<AssignDetailDTO>{
	private AssignDTO assignId;
	private UserDTO userId;
	public AssignDTO getAssignId() {
		return assignId;
	}
	public void setAssignId(AssignDTO assignId) {
		this.assignId = assignId;
	}
	public UserDTO getUserId() {
		return userId;
	}
	public void setUserId(UserDTO userId) {
		this.userId = userId;
	}

	
}
