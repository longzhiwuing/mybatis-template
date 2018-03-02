package com.lzwing.mybatisspringxmldemo;

import com.lzwing.mybatisspringxmldemo.entity.User;
import com.lzwing.mybatisspringxmldemo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(value="dev")
public class MybatisSpringXmlDemoApplicationTests {

	@Autowired
	private UserMapper mapper;

	@Test
//	@Transactional
	public void testInsert(){
		User user = new User();
		user.setUserName("李四");
		user.setAge(26);
		mapper.save(user);
		System.out.println("插入用户信息"+user.getUserName());
	}

	@Test
	public void testSelect(){
		User user = mapper.selectById(1);
		System.out.println(user);
	}

	@Test
	public void testUpdate(){
		User user = mapper.selectById(1);
		System.out.println(user);
		user.setAge(24);
		mapper.updateById(user);
		user = mapper.selectById(1);
		System.out.println(user);

	}


}
