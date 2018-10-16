package com.kinnylee.controller;

import com.kinnylee.dao.base.UserMapper;
import com.kinnylee.dao.custom.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lijl-c on 2018/9/19.
 */
@RestController
public class SpringbootWebController {

  @GetMapping({"/hello", "/"})
  public Object hello(){
    return "hello springboot";
  }

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private UserDao userDao;

  @GetMapping("/user")
  public Object getUser(){
    return userMapper.selectByPrimaryKey(1);
  }

  @GetMapping("/user")
  public Object getUser2(){
    return userDao.selectByPrimaryKey(1);
  }
}
