package com.ly.global;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

/**
 * 
 * @author lyfer
 */
public class InfoShip {

	public static String di() {
		return SerInfo.getHost();
	}
	
	public static String uuid(){
		return UUID.randomUUID().toString();
	}
	
	public static String uuidNoLine(){
		return uuid().replaceAll("-", "");
	}

	public static long getID18() {
		Long time = new Date().getTime();
		time = time - 1300000000000l;
		return (time *= 10000) + (long) (Math.random() * 10000);
	}

	public static long getID16() {
		return (new Date().getTime() - 1300000000000l) * 10000
				+ (long) (Math.random() * 10000);
	}

	public static Timestamp now() {
		return new Timestamp(new Date().getTime());
	}

}