package com.kinnylee.convert;

import com.kinnylee.enums.BaseEnum;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * controller层根据url传来的字符中转换为枚举类.
 * 参考：https://blog.csdn.net/u014527058/article/details/62883573
 *
 * @author lijl-c
 * @date 2018/12/4.
 */
public class EnumConverterFactory implements ConverterFactory<String, BaseEnum> {

  private static final Map<Class, Converter> converterMap = new WeakHashMap<>();


  @Override
  public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
    Converter result = converterMap.get(targetType);
    if (result == null) {
      result = new IntegerStrToEnum<T>(targetType);
      converterMap.put(targetType, result);
    }
    return result;
  }

  class IntegerStrToEnum<T extends BaseEnum> implements Converter<String, T> {

    private final Class<T> enumType;
    private Map<String, T> enumMap = new HashMap<>();

    public IntegerStrToEnum(Class<T> enumType) {
      this.enumType = enumType;
      T[] enums = enumType.getEnumConstants();
      for (T e : enums) {
        enumMap.put(e.getValue() + "", e);
      }
    }


    @Override
    public T convert(String source) {
      T result = enumMap.get(source);
      if (result == null) {
        throw new IllegalArgumentException("No element matches " + source);
      }
      return result;
    }
  }
}
