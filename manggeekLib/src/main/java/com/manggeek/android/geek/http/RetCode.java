package com.manggeek.android.geek.http;

/**
 * 接口响应码
 * 
 * @author Robin 2014年7月14日 下午12:55:42
 */
public class RetCode {

	/** 成功 */
	public static final String SUCCESS = "200";

	/** 系统错误 */
	public static final String SYS_ERROR = "10001";
	/** 没有权限 */
	public static final String NO_PERMITTION = "10002";
	/** 系统繁忙 */
	public static final String SYSTEM_BUSY = "10003";
	/** Illegal request */
	public static final String ILLEGAL_REQUEST = "10004";
	/** 请求方法不支持 */
	public static final String ILLEGAL_REQUEST_METHOD = "10005";

	/* 以下是业务上的错误 */
	/** 参数错误 */
	public static final String ILLEGAL_ARGS = "20001";
	/** 数据异常 */
	public static final String WRONG_DATA = "20002";
	/** 没有数据 */
	public static final String NO_DATA = "20003";

	/*---------------------------Account-----------------------------*/
	/** 用户不存在 */
	public static final String ACCOUNT_NOT_EXISTS = "30001";
	/** 账号已经存在 */
	public static final String ACCOUNT_EXIST = "30002";
	/** 用户名或者密码错误 */
	public static final String ACCOUNT_WRONG_PASSWORD = "30003";
	/** 未绑定 */
	public static final String ACCOUNT_NO_BIND = "30016";
}
