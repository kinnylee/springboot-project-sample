package com.kinnylee.controller;

import com.kinnylee.dao.custom.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lijl-c
 * @date 2018/9/19
 */
@RestController
public class SpringbootWebController {

  @GetMapping({"/hello", "/"})
  public Object hello(){
    return "hello springboot";
  }

  @Autowired
  private UserDao userDao;

  @GetMapping("/test")
  public Object getUser(){
    return userDao.selectByPrimaryKey(1);
  }
}
