package com.kinnylee.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by lijl-c on 2018/10/29.
 */
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
  /**
   * 密钥
   * 系统的简称
   */
  private String base64Security;

  private String issuer;

  public String getBase64Security() {
    return base64Security;
  }

  public void setBase64Security(String base64Security) {
    this.base64Security = base64Security;
  }

  public String getIssuer() {
    return issuer;
  }

  public void setIssuer(String issuer) {
    this.issuer = issuer;
  }
}
