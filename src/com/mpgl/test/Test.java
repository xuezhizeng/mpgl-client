package com.mpgl.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		String str = "2013-Apr-10";
		String[] arrs = {"Apr"};
		String[] months = {"04"};
		for(int i=0; i<arrs.length; i++) {
			String ar = arrs[i];
			if(ar.equals(str.split("-")[1])) {
				str = str.split("-")[0] + "-" + months[i] + "-" + str.split("-")[2];
			}
		}
		SimpleDateFormat sp = new SimpleDateFormat();
		try {
			System.out.print(sp.parse(str));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
