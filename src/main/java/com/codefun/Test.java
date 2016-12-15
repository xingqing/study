package com.codefun;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 
 * @author 作者 : E-mail:
 * @version 创建时间：2016-7-29 上午10:09:57
 * 
 */

public class Test {

	public static void main(String[] args) {

		
		for(int i =0;i<24;i++){
			printProid(i,10,0);
			printProid(i,40,0);		
			
		}
		
		
	}

	public static void printProid(int h, int m, int s) {
		Calendar now = Calendar.getInstance();

		try {
			now.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.parse(String.format("2016-07-29 %s:%s:%s", h, m, s)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int hour1, hour2;
		String proid = "";
		if (now.get(Calendar.MINUTE) > 0 && now.get(Calendar.MINUTE) <= 30) {
			hour1 = now.get(Calendar.HOUR_OF_DAY) - 1;
			if (hour1 == -1) {
				hour1 = 23;
				hour2 = 24;
			} else {
				hour2 = now.get(Calendar.HOUR_OF_DAY);
			}
			proid = String.format("[%s:30-%s:00]", hour1 > 9 ? "" + hour1 : "0"
					+ hour1, hour2 > 9 ? "" + hour2 : "0" + hour2);
		} else {
			hour1 = hour2 = now.get(Calendar.HOUR_OF_DAY);
			proid = String.format("[%s:00-%s:30]", hour1 > 9 ? "" + hour1 : "0"
					+ hour1, hour2 > 9 ? "" + hour2 : "0" + hour2);
		}

		System.out.println(proid);
	}
}
