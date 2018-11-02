package com.kinnylee.service;

import com.kinnylee.config.SlaveDataSource;
import com.kinnylee.dao.custom.UserDao;
import com.kinnylee.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lijl-c
 * @date 2018/11/2
 */
@Service
public class UserService {

  private UserDao userDao;

  @Autowired
  public UserService(UserDao userDao){
    this.userDao = userDao;
  }

  public User searchMaster(){
    return userDao.selectByPrimaryKey(1);
  }

  @SlaveDataSource
  public User searchSlave(){
    return userDao.selectByPrimaryKey(1);
  }
}
