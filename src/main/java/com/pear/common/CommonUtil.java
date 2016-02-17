package com.pear.common;

import java.util.UUID;

public class CommonUtil {
	
	/**
	 * @Title: getUUID
	 * @Description: uuid 主键
	 * @param:
	 * @return:
	 * @author 张鑫磊
	 * @date 2016年2月17日 上午11:06:01
	 */
	public static String getUUID(){
		String s = UUID.randomUUID().toString();
		return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
	}
}
