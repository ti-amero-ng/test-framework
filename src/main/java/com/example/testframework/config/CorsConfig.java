package com.example.testframework.config;

import com.huang.framework.config.GlobalCorsConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author -Huang
 * @create 2020-04-29 14:29
 */
@Configuration
@EnableWebMvc
public class CorsConfig extends GlobalCorsConfig {

}