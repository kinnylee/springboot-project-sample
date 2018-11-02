package com.kinnylee.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 *
 * @author lijl-c
 * @date 2018/11/2
 */
@Configuration
@AutoConfigureAfter({MysqlDataSource.class})
@MapperScan("com.kinnylee.dao")
public class MybatisConfiguration extends MybatisAutoConfiguration{

  @Resource(name = "masterDataSource")
  private DataSource masterDataSource;

  @Resource(name = "slaveDataSource")
  private DataSource slaveDataSource;

  public MybatisConfiguration(MybatisProperties properties,
      ObjectProvider<Interceptor[]> interceptorsProvider,
      ResourceLoader resourceLoader,
      ObjectProvider<DatabaseIdProvider> databaseIdProvider,
      ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider) {
    super(properties, interceptorsProvider, resourceLoader, databaseIdProvider, configurationCustomizersProvider);
  }

  @Bean(name = "dataSource")
  public AbstractRoutingDataSource roundRobinDataSouceProxy(){
    ReadWriteSplitRoutingDataSource proxy = new ReadWriteSplitRoutingDataSource();
    //注册数据源
    Map<Object,Object> targetDataResources = new HashMap<>(2);
    targetDataResources.put(DbContextHolder.DbType.MASTER, masterDataSource);
    targetDataResources.put(DbContextHolder.DbType.SLAVE, slaveDataSource);
    //默认源
    proxy.setDefaultTargetDataSource(masterDataSource);
    proxy.setTargetDataSources(targetDataResources);
    proxy.afterPropertiesSet();
    return proxy;
  }

  @Bean
  @Override
  public SqlSessionFactory sqlSessionFactory(
      @Qualifier("dataSource") DataSource dataSource) throws Exception {
    return super.sqlSessionFactory(roundRobinDataSouceProxy());
  }
}
