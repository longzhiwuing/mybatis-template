package com.lzwing.mybatisspringxmldemo;

import com.lzwing.mybatisspringxmldemo.entity.MyUser;
import com.lzwing.mybatisspringxmldemo.mapper.MyUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/2
 * Time: 11:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(value="dev")
@Slf4j
public class MyUserMapperTest {

    @Autowired
    MyUserMapper myUserMapper;

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
        MyUser user = new MyUser();
        user.setUserId(1);
        user.setUserName("zhangsan");
        user.setPassword("123456");
        user.setPhone("123456789");
        int insert = myUserMapper.insert(user);
        log.info("i:{}",insert);
        assertNotNull(insert);
    }

    @Test
    public void insertSelective() {
        MyUser user = new MyUser();
        user.setUserId(2);
        user.setUserName("lisi");
        user.setPassword("");
        user.setPhone("");
        int i = myUserMapper.insertSelective(user);
        log.info("i:{}",i);
        assertNotNull(i);
    }

    @Test
    public void selectByPrimaryKey() {
        MyUser user = myUserMapper.selectByPrimaryKey(1);
        log.info("user:{}",user);
        assertNotNull(user);
    }

    @Test
    public void updateByPrimaryKeySelective() {
        MyUser user = myUserMapper.selectByPrimaryKey(1);
        user.setUserName("new-zhangsan");
        int update = myUserMapper.updateByPrimaryKeySelective(user);
        log.info("update:{}",update);
        assertNotNull(update);
    }

    @Test
    public void updateByPrimaryKey() {
    }
}