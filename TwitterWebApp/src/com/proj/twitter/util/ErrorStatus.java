package com.proj.twitter.util;

import java.util.ArrayList;
import java.util.List;

public class ErrorStatus {
	
	private List<ErrorCode> errorCodes;
	
	public ErrorStatus(){
		errorCodes = new ArrayList<ErrorCode>();
	}
	
	public List<ErrorCode> getErrorCode() {
		return errorCodes;
	}

	public void setErrorCode(List<ErrorCode> errorCodes) {
		this.errorCodes = errorCodes;
	}
	
	public void addError(ErrorCode errorCode){
		errorCodes.add(errorCode);
	}
	
	public boolean hasError(){
		return errorCodes.size() > 0 ? true: false;
	}

}
