package com.kinnylee.controller;

import com.kinnylee.dao.base.UserMapper;
import com.kinnylee.dao.custom.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lijl-c
 * @date 2018/10/15
 */
@RestController
public class MainController {

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private UserDao userDao;

  @GetMapping("/user")
  public Object getUser(){
    return userMapper.selectByPrimaryKey(1);
  }

  @GetMapping("/user2")
  public Object getUser2(){
    return userDao.selectByPrimaryKey(1);
  }
}
