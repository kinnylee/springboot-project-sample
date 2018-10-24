package com.kinnylee.enums;

/**
 *
 * @author lijl-c
 * @date 2018/10/24
 */
public enum UserStatus {

  /**
   * 不可用
   */
  DISABLE(0),

  /**
   * 可用
   */
  ENABLE(10);

  private int value;

  UserStatus(int value){
    this.value = value;
  }

  public int getValue(){
    return this.value;
  }

  public static UserStatus getValue(int value){
    for (UserStatus us : UserStatus.values()) {
      if(us.getValue() == value){
        return us;
      }
    }
    throw new IllegalArgumentException("Unknown：" + value + ", please check. ");
  }
}
