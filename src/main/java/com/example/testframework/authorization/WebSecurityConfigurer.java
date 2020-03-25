package com.example.testframework.authorization;

import com.huang.framework.authority.config.GlobalWebSecurityConfigurer;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @author -Huang
 * @create 2020-03-20 13:14
 */
@Configuration
@Order(SecurityProperties.BASIC_AUTH_ORDER)
public class WebSecurityConfigurer extends GlobalWebSecurityConfigurer {

}
