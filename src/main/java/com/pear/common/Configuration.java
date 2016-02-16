package com.pear.common;
/**
 * @ClassName: Configuration
 * @Description: 配置文件
 * @author 张鑫磊
 * @date 2016年2月15日 上午10:38:01
 */
public class Configuration {
	/** total键 存放总记录数，必须的 ,EasyUI根据这个参数，可以计算page和number的值，这个值不是users的长度 */
	public static final String TOTAL = "total";
	/** rows键 存放每页记录 list */
	public static final String DATA = "rows";
	public static final String SUCCESS = "success";
	public static final String MESSAGE = "message";
}
