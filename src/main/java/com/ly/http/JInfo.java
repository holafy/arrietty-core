package com.ly.http;

import java.util.Map;

import ivy.basic.ViException;
import ivy.json.Json;

/**
 * 一个用于前后台交互的消息体
 * 
 * @author holaivy@gmail.com
 * 
 * @param <T>
 */
public class JInfo<T> {
	public static final int SUCCESSSTATE = 1;
	public static final int FAULTSTATE = -1;
	public static final int UNINITIALIZED = 0;
	public static final int SESSIONOUT = 2;
	public static final int VALIDATIONFAILURE = -2;
	private int infocode = SUCCESSSTATE;

	private String infomessage = "";
	private Map<String, String> vfms;
	private T data;

	public int getInfocode() {
		return infocode;
	}

	public void setInfocode(int infocode) {
		this.infocode = infocode;
	}

	public String getInfomessage() {
		return infomessage;
	}

	public void setInfomessage(String infomessage) {
		this.infomessage = infomessage;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	/**
	 * 请求是否成功完成
	 * 
	 * @return
	 */
	public boolean fine() {
		return infocode == SUCCESSSTATE;
	}

	/**
	 * 标记请求状态为成功
	 */
	public void success() {
		infocode = SUCCESSSTATE;
	}

	/**
	 * 标记请求状态为成功
	 * 
	 * @param m
	 *            成功信息
	 */
	public void success(String m) {
		infocode = SUCCESSSTATE;
		infomessage = m;
	}

	/**
	 * 标记请求状态为失败.
	 */
	public void fault() {
		infocode = FAULTSTATE;
	}

	/**
	 * 标记请求状态为失败.
	 * 
	 * @param m
	 *            失败信息
	 */
	public void fault(String m) {
		infocode = FAULTSTATE;
		infomessage = m;
	}

	/**
	 * 标记请求为失败
	 * 
	 * @param m
	 *            失败信息
	 * @param faultCode
	 *            失败代码
	 */
	public void fault(String m, int faultCode) {
		infomessage = m;
		infocode = faultCode;
	}

	/**
	 * 标记请求为失败
	 * 
	 * @param e
	 *            失败异常信息
	 */
	public void fault(Exception e) {
		if (e != null)
			infomessage = e.getMessage();
		infocode = FAULTSTATE;
	}

	/**
	 * 设置请求数据的数据内容
	 * 
	 * @param value
	 * @return
	 */
	public T pushData(T value) {
		return data = value;
	}

	/**
	 * 获取请求数据的数据内容
	 * 
	 * @return
	 */
	public T fetch() {
		return data;
	}

	/**
	 * 获取请求数据的数据内容
	 * 
	 * @return
	 */
	public T fetchData() {
		return data;
	}

	public String toString() {
		String er;
		try {
			return Json.encode(this);
		} catch (ViException e) {
			e.printStackTrace();
			er = e.getMessage();
		}
		return er;
	}

	public Map<String, String> getVfms() {
		return vfms;
	}

	public void setVfms(Map<String, String> vfms) {
		this.vfms = vfms;
	}

}
