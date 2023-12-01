package com.cusc.htqltuyensinh.api.output;

public class ErrorOutput {
	private String message;
    private int status;

    public ErrorOutput(String message, int status) {
        this.message = message;
        this.status = status;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
    
    
}
