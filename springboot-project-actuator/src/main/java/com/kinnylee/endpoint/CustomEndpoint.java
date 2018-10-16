package com.kinnylee.endpoint;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 自定义actuator访问的rest api路径, 定义好后需要注册到spring容器中
 * @Endpoint 注解指定了url, 暴露给jxm和http，其他注解包括
 *    @JmxEndoint 只暴露给jmx，不暴露给http
 *    @WebEndpoint 只暴露给http，不暴露给jmx
 *    @EndpointWebExtension
 *    @EndpointJmxExtension
 *
 * @ReadOperation Get 没有实现则返回404
 * @WriteOperation Post 没有实现则返回404
 * Created by lijl-c on 2018/9/28.
 */
@Endpoint(id = "custom")
public class CustomEndpoint {

  @ReadOperation
  public Map<String, String> hello(){
    Map<String, String> result = new HashMap<>(4);
    result.put("author", "kinnylee");
    result.put("version", "0.0.1");
    result.put("project", "spring boot custom actuator");
    return result;
  }
}
