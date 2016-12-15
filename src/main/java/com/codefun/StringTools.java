package com.codefun;

import java.security.MessageDigest;
import java.util.ArrayList;

public class StringTools {
	public static String[] subStringByCode(String str, String code) {
		int subStart = 0;
		int subEnd = 0;
		String strRs = null;
		int strLength = str.length();
		ArrayList arrayList = new ArrayList();
		while (subEnd < strLength) {
			subEnd = str.indexOf(code, subStart);
			if (subEnd == -1)
				subEnd = strLength;
			strRs = str.substring(subStart, subEnd);
			arrayList.add(strRs);
			subStart = subEnd + 1;
		}
		int arrayLength = arrayList.size();
		String[] strArray = new String[arrayLength];
		for (int i = 0; i < arrayLength; ++i) {
			strArray[i] = arrayList.get(i).toString();
		}
		return strArray;
	}

	public static double[] changeArray(String[] strArray) {
		int arrayLength = strArray.length;
		double[] doubleArray = new double[arrayLength];
		for (int i = 0; i < arrayLength; ++i) {
			doubleArray[i] = Double.parseDouble(strArray[i]);
		}
		return doubleArray;
	}

	public static String md5Encode(String sourceString) {
		String resultString = null;
		try {
			resultString = new String(sourceString);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byte2hexString(md.digest(resultString.getBytes()));
		} catch (Exception localException) {
		}
		return resultString;
	}

	public static final String byte2hexString(byte[] bytes) {
		StringBuffer buf = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; ++i) {
			if ((bytes[i] & 0xFF) < 16)
				buf.append("0");
			buf.append(Long.toString(bytes[i] & 0xFF, 16));
		}

		return buf.toString();
	}

	public static void main(String[] args) {
		System.out.println(StringTools.md5Encode("12345678"));
	}

}