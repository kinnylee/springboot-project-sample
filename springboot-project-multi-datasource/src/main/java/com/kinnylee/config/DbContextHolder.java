package com.kinnylee.config;

/**
 * 线程变量，因为每个请求是一个线程，所以通过这样来区分使用哪个库
 * @author lijl-c
 * @date 2018/7/18
 */
public class DbContextHolder {

  public enum DbType{
    MASTER,SLAVE
  }

  private static final ThreadLocal<DbType> contextHolder = new ThreadLocal<>();

  public static void setDbType(DbType dbType){
    if(dbType==null){
      throw new NullPointerException();
    }
    contextHolder.set(dbType);
  }

  public static DbType getDbType(){
    return contextHolder.get()==null? DbType.MASTER:contextHolder.get();
  }

  public static void clearDbType(){
    contextHolder.remove();
  }
}