package com.vahan.oauth;

/**
 * Created by vahan on 2/2/17.
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;


@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {


    @Override
    public void configure(final ResourceServerSecurityConfigurer resources) {
        resources
                .resourceId("/rest/api")
                .stateless(false);
    }

    @Override
    public void configure(final HttpSecurity http) throws Exception {
        http
                .anonymous()
                .disable()
                .requestMatchers()
                .antMatchers("/hi/**")
                .and()
                .authorizeRequests()
                .antMatchers("/hi/secured")
                .access("hasRole('ADMIN')")
                .and()

                .exceptionHandling()
                .accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }

}