package com.cusc.htqltuyensinh.api.output;

import com.cusc.htqltuyensinh.dto.UserDTO;

public class UserOutput extends AbstractOutput<UserDTO>{
	private UserDTO user;

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}
