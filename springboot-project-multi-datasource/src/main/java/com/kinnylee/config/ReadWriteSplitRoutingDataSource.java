package com.kinnylee.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 读写分离数据源
 * 它是通过determineCurrentLookupKey（）返回的不同key到sqlSessionFactory中获取不同源
 * @author lijl-c
 * @date 2018/7/18
 */
public class ReadWriteSplitRoutingDataSource extends AbstractRoutingDataSource {

  /**
   * 重新子类，
   * AbstractRoutingDataSource 中保存的多个数据源是通过Map的方式保存的
   * 该方法确定当前应该使用哪个数据源的key
   * @return
   */
  @Override
  protected Object determineCurrentLookupKey() {
    return DbContextHolder.getDbType();
  }
}
