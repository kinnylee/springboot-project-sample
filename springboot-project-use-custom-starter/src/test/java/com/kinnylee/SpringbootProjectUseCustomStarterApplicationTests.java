package com.kinnylee;

import com.kinnylee.starter.JwtService;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootProjectUseCustomStarterApplicationTests {

	@Autowired
	private JwtService jwtService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testStarter(){
		Map map = new HashMap();
		map.put("user", "kinnylee");
		System.out.println(jwtService.createPersonToken(map, "1402753117", 200));
	}
}
