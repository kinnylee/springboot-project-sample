package com.kinnylee.config;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by lijl-c on 2018/9/19.
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception{
    http.authorizeRequests()
        .antMatchers("/")
        .access("hasRole('READER')")
        .antMatchers("/**")
        .permitAll()
        .and()
        .formLogin()
        .loginPage("/login")
        .failureUrl("/login?error=ture");
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    auth.userDetailsService(new UserDetailsService() {
      @Override
      public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new UserDetails() {
          @Override
          public Collection<? extends GrantedAuthority> getAuthorities() {
            return null;
          }

          @Override
          public String getPassword() {
            return null;
          }

          @Override
          public String getUsername() {
            return null;
          }

          @Override
          public boolean isAccountNonExpired() {
            return false;
          }

          @Override
          public boolean isAccountNonLocked() {
            return false;
          }

          @Override
          public boolean isCredentialsNonExpired() {
            return false;
          }

          @Override
          public boolean isEnabled() {
            return false;
          }
        };
      }
    });
  }
}
