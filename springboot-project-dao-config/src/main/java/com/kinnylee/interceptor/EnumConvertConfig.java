package com.kinnylee.interceptor;

import com.kinnylee.convert.EnumConverterFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * .
 *
 * @author lijl-c
 * @date 2018/12/4.
 */
@Configuration
public class EnumConvertConfig implements WebMvcConfigurer {

  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addConverterFactory(new EnumConverterFactory());
  }
}
