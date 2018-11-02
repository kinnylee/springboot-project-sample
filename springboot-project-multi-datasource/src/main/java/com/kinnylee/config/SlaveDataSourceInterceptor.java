package com.kinnylee.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * spring aop对注解进行拦截
 *
 * @author lijl-c
 * @date 2018/7/18
 */
@Aspect
@Component
public class SlaveDataSourceInterceptor implements Ordered {

  public static final Logger logger = LoggerFactory.getLogger(SlaveDataSourceInterceptor.class);

  @Around("@annotation(slaveDataSource)")
  public Object proceed(ProceedingJoinPoint proceedingJoinPoint, SlaveDataSource slaveDataSource) throws Throwable {
    try {
      logger.debug("set database connection to read only");
      DbContextHolder.setDbType(DbContextHolder.DbType.SLAVE);
      return proceedingJoinPoint.proceed();
    }finally {
      DbContextHolder.clearDbType();
      logger.debug("restore database connection");
    }
  }

  @Override
  public int getOrder() {
    return 0;
  }
}

