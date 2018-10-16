package com.kinnylee;

import com.kinnylee.dao.base.UserMapper;
import com.kinnylee.dao.custom.UserDao;
import com.kinnylee.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootProjectDaoApplicationTests {

	@Autowired
	UserDao userDao;
	@Test
	public void contextLoads() {
	}

	@Test
	public void test(){
		User user = userDao.selectByPrimaryKey(1);
		System.out.println(user.getName());
	}
}
