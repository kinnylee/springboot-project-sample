package com.kinnylee;

import com.kinnylee.entity.User;
import com.kinnylee.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootProjectCacheApplicationTests {

	private Logger logger = LoggerFactory.getLogger(SpringbootProjectCacheApplicationTests.class);

	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCache() {
		final User user1 = userService.get(1L);
		logger.info(user1.toString());

//		final User user4 = userService.get(4L);
//		logger.info(user4.toString());

		final User user = userService.saveOrUpdate(new User(4L, "u4", "p4"));
		userService.saveOrUpdate(user);
		logger.info(user.toString());
//
//		final User user44 = userService.get(4L);
//		logger.info(user44.toString());
//
//		userService.delete(4L);
	}

}
