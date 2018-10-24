package com.kinnylee.controller;

import com.kinnylee.dao.custom.UserDao;
import com.kinnylee.entity.User;
import com.kinnylee.enums.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
  public Object getUser(@RequestParam Integer id){
    return userDao.selectByPrimaryKey(id);
  }

  @PostMapping("/add")
  public Object addUser(){
    User user = new User();
    user.setName("test");
    user.setSex(Sex.FEMALE);
    return userDao.insertSelective(user);
  }
}
