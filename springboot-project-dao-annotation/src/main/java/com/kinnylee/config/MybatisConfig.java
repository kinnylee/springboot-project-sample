package com.kinnylee.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 数据源作为多模块的子模块独立时，手动配置数据源，
 * 可以避免在每个使用dao的子模块中重复配置@MapperScan
 *
 * 注意：
 *    1. url格式为spring.datasource.url， 而不是spring.datasource.jdbc-url
 *    2. 不能使用yml格式配置文件
 * @author lijl-c
 * @date 2018/10/16
 */
@Configuration
@MapperScan("com.kinnylee.dao")
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true)
public class MybatisConfig {

}
