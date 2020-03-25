package com.example.testframework.config;

import com.huang.framework.config.GlobalReturnConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author -Huang
 * @create 2020-03-20 21:04
 */
@EnableWebMvc
@Configuration
@RestControllerAdvice({"com.example.testframework.controller"})
public class ReturnConfig extends GlobalReturnConfig {
}
