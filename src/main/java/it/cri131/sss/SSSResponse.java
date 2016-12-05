package it.cri131.sss;

import java.io.InputStream;

import fi.iki.elonen.NanoHTTPD.Response.Status;

public class SSSResponse {
	
	private Status httpStatus;
	private String mimeType;
	private InputStream response;
	
	public SSSResponse() { };
	
	public SSSResponse(Status httpStatus, String mimeType, InputStream response) {
		this.httpStatus = httpStatus;
		this.mimeType = mimeType;
		this.response = response;
	}

	public Status getHttpStatus() {
		return httpStatus;
	}
	
	public void setHttpStatus(Status httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	public String getMimeType() {
		return mimeType;
	}
	
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	
	public InputStream getResponse() {
		return response;
	}
	
	public void setResponse(InputStream response) {
		this.response = response;
	}

}
