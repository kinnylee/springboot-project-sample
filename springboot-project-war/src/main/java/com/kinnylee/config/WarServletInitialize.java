package com.kinnylee.config;

import com.kinnylee.SpringbootProjectWarApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

/**
 * Created by lijl-c on 2018/9/20.
 */
public class WarServletInitialize extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(SpringbootProjectWarApplication.class);
  }
}
