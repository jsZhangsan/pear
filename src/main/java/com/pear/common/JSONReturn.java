package com.pear.common;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName: JSONReturn
 * @Description: json�����
 * @author ������
 * @date 2016��2��15�� ����10:43:26
 */
public class JSONReturn {
	private Map<String, Object> dataMap;
	
	/**
	 * 
	 * @Title: newInstance
	 * @Description: springMVC Ĭ��controller����
	 * @param:
	 * @return:
	 * @author ������
	 * @date 2016��2��15�� ����5:52:37
	 */
	public static JSONReturn newInstance(){
		return new JSONReturn();
	}
	
	private JSONReturn() {
		dataMap = new HashMap<String, Object>();
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	
	/**
	 * Generates modelMap to return in the modelAndView
	 * @param data
	 * @return
	 */
	public String page(Collection<? extends Object> list){
		dataMap.clear();
		dataMap.put(Configuration.TOTAL, list.size());
		dataMap.put(Configuration.DATA, list);
		dataMap.put(Configuration.SUCCESS, true);
		return JSON.toJSONString(dataMap);
	}
	
	/**
	 * Generates modelMap to return in the modelAndView
	 * @param data
	 * @return
	 */
	public String json(Object data){
		dataMap.clear();
		dataMap.put(Configuration.DATA, data);
		dataMap.put(Configuration.SUCCESS, true);
		return JSON.toJSONString(dataMap);
	}
	
	/**
	 * Generates modelMap to return in the modelAndView
	 * @param data
	 * @return
	 */
	public String json(){
		dataMap.clear();
		dataMap.put(Configuration.SUCCESS, true);
		return JSON.toJSONString(dataMap);
	}
	
	/**
	 * Generates modelMap to return in the modelAndView
	 * @param data
	 * @return
	 */
	public String json(boolean boo){
		dataMap.clear();
		dataMap.put(Configuration.SUCCESS, boo);
		return JSON.toJSONString(dataMap);
	}
	
}
