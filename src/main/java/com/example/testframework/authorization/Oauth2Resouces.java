package com.example.testframework.authorization;

import com.huang.framework.authority.auth2.OAuth2ResourceServerConfig;
import com.huang.framework.authority.config.CloseAuthorityEvironment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * @author -Huang
 * @create 2020-03-20 13:15
 */
@Configuration
public class Oauth2Resouces extends OAuth2ResourceServerConfig {
    @Value("${spring.profiles.active}")
    private String currentRunEnvironment;

    /**
     * 用户自定义配置，子类可覆盖自定义实现
     * @param http
     * @throws Exception
     */
    @Override
    protected HttpSecurity customConfigure(HttpSecurity http) throws Exception{
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers("/code").permitAll()
                .antMatchers( "/read").access("#oauth2.hasScope('all')")
                .antMatchers( "/write").access("#oauth2.hasScope('write')")
                .anyRequest().authenticated();
        return http;
    }

    /**
     * 指定某种运行环境下关闭权限校验；为了方便开发，一般我们的dev环境会关闭接口权限校验
     * @return
     */
    @Override
    public CloseAuthorityEvironment customCloseAuthorityEvironment(){
        return new CloseAuthorityEvironment(currentRunEnvironment,"dev");
    }
}
