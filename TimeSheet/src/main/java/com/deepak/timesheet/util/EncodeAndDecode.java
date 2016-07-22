package com.deepak.timesheet.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncodeAndDecode {
	public static String cryptWithMD5(String pass) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] passBytes = pass.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < digested.length; i++) {
				sb.append(Integer.toHexString(0xff & digested[i]));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException ex) {

			System.out.println(ex.getStackTrace());
		}
		return null;

	}
}
