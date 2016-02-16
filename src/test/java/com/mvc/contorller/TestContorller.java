package com.mvc.contorller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pear.dao.TUserMapper;
import com.pear.model.TUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestContorller {
	private static Logger logger = Logger.getLogger(TestContorller.class);
	@Resource
	private TUserMapper tUserMapper;
	
	@Test
	public void TestMapper() {
		TUser u = tUserMapper.selectByPrimaryKey("1");
		logger.info("ֵ===>" + u.getUserName());
	}

}
