package com.kinnylee.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author lijl-c
 * @date 2018/10/29
 */
@Configuration
@ConditionalOnClass(JwtService.class)
@EnableConfigurationProperties(JwtProperties.class)
public class JwtAutoConfiguration {

  @Autowired
  private JwtProperties jwtProperties;

  @Bean
  JwtService jwtService(){
    return new JwtService(jwtProperties.getBase64Security(), jwtProperties.getIssuer());
  }

  @Bean
  @ConditionalOnMissingBean
  @ConditionalOnProperty(prefix="jwt", value = "enabled", havingValue = "true")
  JwtUtils jwtUtils(){
    return new JwtUtils();
  }
}
