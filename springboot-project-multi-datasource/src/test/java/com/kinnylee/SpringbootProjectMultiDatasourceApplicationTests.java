package com.kinnylee;

import com.kinnylee.config.SlaveDataSource;
import com.kinnylee.dao.custom.UserDao;
import com.kinnylee.entity.User;
import com.kinnylee.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootProjectMultiDatasourceApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testMaster(){
		User user = userService.searchMaster();
		System.out.println(user);
	}

	@Test
	public void testSlave(){
		User user = userService.searchSlave();
		System.out.println(user);
	}
}
