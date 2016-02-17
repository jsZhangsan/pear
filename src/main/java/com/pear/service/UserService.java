package com.pear.service;

import com.pear.model.Login;

public interface UserService {
	/**
	 * @Title: addUser
	 * @Description: ע���û�,����˺ź��û�
	 * @param:
	 * @return:
	 * @author ������
	 * @date 2016��2��17�� ����2:54:38
	 */
	int addUser(Login login);
	
	/**
	 * @Title: getLoginByUsername
	 * @Description: ��ѯ�˺�,�����û���
	 * @param:
	 * @return:
	 * @author ������
	 * @date 2016��2��17�� ����2:56:41
	 */
	Login getLoginByUsername(String username);
}
