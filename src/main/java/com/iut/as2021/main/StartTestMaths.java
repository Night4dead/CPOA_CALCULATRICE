package com.iut.as2021.main;


import java.text.DecimalFormat;

public class StartTestMaths {

	public static void main(String[] args) {
		double d = 1.2/10000000;
		DecimalFormat df = new DecimalFormat("#");
		df.setMaximumFractionDigits(100);
		System.out.println(df.format(d));
		String sd = String.valueOf(d);
		System.out.println(sd);
	}
}
