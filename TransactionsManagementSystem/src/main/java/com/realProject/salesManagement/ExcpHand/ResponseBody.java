package com.realProject.salesManagement.ExcpHand;

public class ResponseBody {
	private String message;
	private int statusCode;
	private Long timestamps;

	public ResponseBody(String message, int statusCode, Long timestamps) {
		this.message = message;
		this.statusCode = statusCode;
		this.timestamps = timestamps;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Long getTimestamps() {
		return timestamps;
	}

	public void setTimestamps(Long timestamps) {
		this.timestamps = timestamps;
	}

}
