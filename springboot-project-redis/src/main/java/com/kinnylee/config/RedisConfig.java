package com.kinnylee.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis配置类.
 *
 * 主要修改序列化方式，默认的序列化方式会导致肉眼看上去是乱码的，改成json格式
 *
 * 默认的序列化方式
 *  redisTemplate.getKeySerializer()-->JdkSerializationRedisSerializer
    redisTemplate.getDefaultSerializer()-->JdkSerializationRedisSerializer
    redisTemplate.getStringSerializer()-->StringRedisSerializer
    redisTemplate.getValueSerializer()-->JdkSerializationRedisSerializer
    redisTemplate.getHashKeySerializer()-->JdkSerializationRedisSerializer
    redisTemplate.getHashValueSerializer()-->JdkSerializationRedisSerializer

 * @author lijl-c
 * @date 2018/11/14
 */
@Configuration
public class RedisConfig {

  /**
   * 自动注入redisClient对象.
   */
  @Bean
  public RedisTemplate redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
    ObjectMapper om = new ObjectMapper();
    om.setVisibility(PropertyAccessor.ALL, Visibility.ANY);
    om.enableDefaultTyping(DefaultTyping.NON_FINAL);
    // 使用jackson序列化，代替默认的序列化方式
    Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
    jackson2JsonRedisSerializer.setObjectMapper(om);

    StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
    // 配置redisTemplate
    RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(lettuceConnectionFactory);
    // 设置默认的序列化方式，或者通过下面的方法单独设置每一种序列化方式
    redisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);
    // key序列化
//    redisTemplate.setKeySerializer(stringRedisSerializer);
//    redisTemplate.setHashKeySerializer(stringRedisSerializer);
    // value序列化
//    redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
    // Hash value序列化
//    redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
    redisTemplate.afterPropertiesSet();
    return redisTemplate;
  }

}
