package com.kinnylee.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * 数据源作为多模块的子模块独立时，yml格式配置文件，需要手动配置数据源
 * @author lijl-c
 * @date 2018/10/16
 */
@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.kinnylee.dao")
@PropertySource(value = "classpath:mybatis.properties", ignoreResourceNotFound = true)
public class MybatisConfig {

  @Value("${mybatis.mapper-locations}")
  private String mapperLocationPattern;

  @Value("${mybatis.config-location}")
  private String configLocation;


  @Bean("dataSource")
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource dataSource(){
    return DataSourceBuilder.create().build();
  }

  @Bean("sqlSessionFactory")
  public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception{
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    factoryBean.setDataSource(dataSource);

    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    factoryBean.setMapperLocations(resolver.getResources(mapperLocationPattern));
    factoryBean.setConfigLocation(resolver.getResource(configLocation));
    return factoryBean.getObject();
  }
}
