package com.kinnylee.service;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kinnylee.entity.User;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * .
 *
 * @author lijl-c
 * @date 2018/11/28.
 */
@Service
public class UserService {

  @Autowired
  private RedisTemplate redisTemplate;

  public void getSerialize() {
    System.out.println(redisTemplate.getKeySerializer());
    System.out.println(redisTemplate.getDefaultSerializer());
    System.out.println(redisTemplate.getStringSerializer());
    System.out.println(redisTemplate.getValueSerializer());
    System.out.println(redisTemplate.getHashKeySerializer());
    System.out.println(redisTemplate.getHashValueSerializer());
  }

  public void setValue() {
    redisTemplate.opsForValue().set("test", "1");
  }

  public void setHash() {
    redisTemplate.opsForHash().put("hash_test", "11", new User(1L, "u1", "p1"));
  }

  public void jackson() {
    User user = new User(1L, "u1", "p1");
    ObjectMapper objectMapper = new ObjectMapper();
    //反序列化时，json中有，但是java实体类没有的属性，忽略它。
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    //在序列化时日期格式默认为 yyyy-MM-dd'T'HH:mm:ss.SSSZ
    objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    //忽略值为null的属性
    objectMapper.setSerializationInclusion(Include.NON_NULL);

    try {
      String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
      System.out.println(jsonString);

      User user1 = objectMapper.readValue(jsonString, User.class);
      System.out.println(user1);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
