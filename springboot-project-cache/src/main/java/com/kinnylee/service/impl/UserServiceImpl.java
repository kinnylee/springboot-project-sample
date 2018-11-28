package com.kinnylee.service.impl;

import com.kinnylee.entity.User;
import com.kinnylee.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * .
 *
 * @author lijl-c
 * @date 2018/11/28.
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {

  private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

  private static final Map<Long, User> USERS = new HashMap<>();

  @Override
// 不允许空值缓存，配合properties中的spring.cache.redis.cache-null-values=false
//  @Cacheable(unless = "#result == null")
  @Cacheable
  public User get(Long id) {
    logger.info("查询数据：{}", id);
    return USERS.get(id);
  }

  static {
    USERS.put(1L, new User(1L, "u1", "p1"));
    USERS.put(2L, new User(2L, "u2", "p3"));
    USERS.put(3L, new User(2L, "u2", "p3"));
  }

  @Override
  @CachePut(value="user", key="#user.id")
  public User saveOrUpdate(User user) {
    logger.info("保存或修改数据：", user.getId());
    USERS.put(user.getId(), user);
    return user;
  }

  @Override
  @CacheEvict(value="user")
  public void delete(Long id) {
    logger.info("删除数据：", id);
    USERS.remove(id);
  }

  @Override
  public void printAll() {
    for(Entry<Long, User> entry : USERS.entrySet()) {
      logger.info(entry.toString());
    }
  }
}
