package com.pear.common;

import java.util.UUID;

public class CommonUtil {
	
	/**
	 * @Title: getUUID
	 * @Description: uuid ����
	 * @param:
	 * @return:
	 * @author ������
	 * @date 2016��2��17�� ����11:06:01
	 */
	public static String getUUID(){
		String s = UUID.randomUUID().toString();
		return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
	}
}
