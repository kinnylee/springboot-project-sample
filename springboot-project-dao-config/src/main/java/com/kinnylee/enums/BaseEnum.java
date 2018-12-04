package com.kinnylee.enums;

/**
 * 枚举类转换接口，需要实现controller层自动转换的枚举类实现该接口.
 * 参考：https://blog.csdn.net/u014527058/article/details/62883573
 *
 * @author lijl-c
 * @date 2018/12/4.
 */
public interface BaseEnum {

  /**
   * 获取枚举值的方法.
   * @return
   */
  int getValue();

}
