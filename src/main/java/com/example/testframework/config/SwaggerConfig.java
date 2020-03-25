package com.example.testframework.config;

import com.huang.framework.config.swagger.GlobalSwaggerConfig;
import com.huang.framework.config.swagger.SwaggerApiInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author -Huang
 * @create 2019-09-29 8:43
 */
@Configuration
public class SwaggerConfig extends GlobalSwaggerConfig {
    @Value("${swagger.enable}")
    private boolean enable;

    @Override
    protected List<SwaggerApiInfo> configureSwaggerApiInfo() {

        List<SwaggerApiInfo> swaggerApiInfos = new ArrayList<>();

        SwaggerApiInfo userModelApiInfo = new SwaggerApiInfo("用户模块API接口文档","com.example.testframework.controller","V1.0");
        swaggerApiInfos.add(userModelApiInfo);

        return swaggerApiInfos;
    }
}