package org.identifiers.cloud.ws.resourcerecommender.configurations;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class LoggersSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/actuator/loggers/**").authenticated()
                .antMatchers(HttpMethod.GET, "/actuator/health/**").permitAll()
                .antMatchers(HttpMethod.POST,"/").permitAll()
            .and()
                .httpBasic()
            .and()
                .csrf().disable();
    }
}
