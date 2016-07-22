package com.deepak.timesheet.util;

public class StringUtils {

	public static boolean notNullOrBlank(String str) {
		if ((str != null) && (str.trim().length() > 0))
			return true;
		else
			return false;
	}

}
