package com.ly.util;

import java.text.DecimalFormat;

/**
 * 计算耗时
 * 
 * @author holaivy@gmail.com
 * 
 */
public class CT {

	public CT() {
		super();
		s = System.nanoTime();
	}

	private long s;
	private long e;
	private double value;

	public void start() {
		s = System.nanoTime();
	}

	public double end() {
		e = System.nanoTime();
		LogU.d(calc());
		return value;
	}

	private String calc() {
		value = (e - s) / 1000.0 / 1000.0 / 1000.0;
		DecimalFormat df = new DecimalFormat("#.0000");
		return df.format(value) + " [Second]";
	}

}
