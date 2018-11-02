package com.kinnylee.config;

import com.kinnylee.config.DbContextHolder.DbType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SlaveDataSource {
  DbType dataSourceKey() default DbType.MASTER;
}