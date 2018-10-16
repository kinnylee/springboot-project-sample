package com.kinnylee.config;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author lijl-c
 * @date 2018/9/27
 */
@Configuration
public class SecuritySecureConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private AdminServerProperties adminServerProperties;

  @Override
  protected void configure(HttpSecurity http) throws Exception{
    String contextPath = adminServerProperties.getContextPath();

    http.formLogin().loginPage(contextPath + "/login.html").loginProcessingUrl(
        contextPath + "/login").defaultSuccessUrl(contextPath + "/").permitAll();
    http.logout().logoutUrl(contextPath + "/logout");
    http.csrf().disable();

    http.authorizeRequests().antMatchers(contextPath + "/login.html", "/**/*.css",
        contextPath + "/img/**", contextPath + "/third-party/**").permitAll();
    http.authorizeRequests().antMatchers("/**").authenticated();
    http.httpBasic();
  }
}
