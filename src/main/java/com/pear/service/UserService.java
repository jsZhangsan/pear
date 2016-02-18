package com.pear.service;

import java.util.List;
import java.util.Map;

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
	
	/**
     * @Title: selectUserAndLogin
     * @Description: ��ѯ�û��˺�����
     * @param:
     * @return:
     * @author ������
     * @date 2016��2��18�� ����3:19:39
     */
    List<Map<String, Object>> selectUserAndLogin(Map<String, Object> map);
}
