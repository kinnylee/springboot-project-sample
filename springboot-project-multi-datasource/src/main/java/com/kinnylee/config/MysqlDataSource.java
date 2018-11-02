package com.kinnylee.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

/**
 * 取配置文件，实例化数据源.
 * @author lijl-c
 * @date 2018/11/2
 */
@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@PropertySource(value = "classpath:mybatis.properties", ignoreResourceNotFound = true)
public class MysqlDataSource {

  @Value("${spring.datasource.type}")
  private Class<? extends DataSource> dataSourceType;

  @Bean(name = "masterDataSource")
  @Primary
  @ConfigurationProperties(prefix = "spring.datasource.master")
  public DataSource masterDataSource(){
    return DataSourceBuilder.create().type(dataSourceType).build();
  }

  @Bean(name = "slaveDataSource")
  @ConfigurationProperties(prefix = "spring.datasource.slave")
  public DataSource slaveDataSource(){
    return DataSourceBuilder.create().type(dataSourceType).build();
  }

}
