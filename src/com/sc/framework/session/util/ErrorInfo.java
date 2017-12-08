package com.sc.framework.session.util;

import java.util.Date;

public class ErrorInfo {
	
	private int count = 0;
	
	private Date lastErrorTime = new Date();

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getLastErrorTime() {
		return lastErrorTime;
	}

	public void setLastErrorTime(Date lastErrorTime) {
		this.lastErrorTime = lastErrorTime;
	}
	
}
