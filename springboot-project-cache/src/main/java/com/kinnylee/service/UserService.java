package com.kinnylee.service;

import com.kinnylee.entity.User;

/**
 * .
 *
 * @author lijl-c
 * @date 2018/11/28.
 */
public interface UserService {

  User get(Long id);

  User saveOrUpdate(User user);

  void delete(Long id);

  void printAll();

}
