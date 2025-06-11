package org.datangapps.projectmanagement.utils.common;

public class DataConverterUtils {

	public static String getGender(String input) {
		
		String result = "PRIA";
		
		if (input.toUpperCase().equals("P"))
			result = "PRIA";
		else if (input.toUpperCase().equals("W"))
			result = "WANITA";
		
		return result;
	}
}
