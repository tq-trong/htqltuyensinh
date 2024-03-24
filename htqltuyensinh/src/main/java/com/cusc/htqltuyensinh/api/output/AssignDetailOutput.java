package com.cusc.htqltuyensinh.api.output;

import com.cusc.htqltuyensinh.dto.AssignDetailDTO;

public class AssignDetailOutput extends AbstractOutput<AssignDetailDTO>{
	private AssignDetailDTO assignDetail;

	public AssignDetailDTO getAssign() {
		return assignDetail;
	}

	public void setAssign(AssignDetailDTO assignDetail) {
		this.assignDetail = assignDetail;
	}
	
	
}
