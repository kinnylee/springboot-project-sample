package com.kinnylee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lijl-c on 2018/9/19.
 */
@RestController
public class SpringbootWebController {

  @GetMapping({"/hello", "/"})
  public Object hello(){
    return "hello springboot";
  }

}
