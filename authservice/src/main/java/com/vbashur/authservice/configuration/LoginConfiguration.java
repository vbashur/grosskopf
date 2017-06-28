package com.vbashur.authservice.configuration;

import com.vbashur.authservice.security.JWTAuthenticationFilter;
import com.vbashur.authservice.security.JWTLoginFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled=true)
public class LoginConfiguration extends WebSecurityConfigurerAdapter {

    Logger log = LoggerFactory.getLogger(LoginConfiguration.class);

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

//    @Autowired
//    private AuthenticationManager authenticationManager;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
//        http
//                .csrf().disable()
//                .formLogin().loginPage("/login").permitAll()
//                .and()
//                .requestMatchers().antMatchers("/login", "/index", "/oauth/authorize", "/oauth/confirm_access", "/test")
//                .and()
//                .httpBasic()
//                .realmName(Const.REALM)
//                .authenticationEntryPoint(getBasicAuthEntryPoint())
//                .and()
//                .authorizeRequests()
//                .anyRequest().authenticated();
        // @formatter:on

//        http
//                .csrf().disable()
//                .formLogin().loginPage("/login").permitAll()
//                .and()
//                .requestMatchers().antMatchers("/login", "/oauth/authorize", "/oauth/confirm_access")
//                .and()
//                .httpBasic()
//                .realmName(Const.REALM)
//                .authenticationEntryPoint(getBasicAuthEntryPoint())
//                .and()
//                .authorizeRequests().anyRequest().authenticated();

        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                .authorizeRequests()
                .antMatchers("/**").authenticated()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.parentAuthenticationManager(authenticationManager);
        auth.inMemoryAuthentication()
                .withUser("user").password("user").roles("USER").authorities("USER")
                .and().withUser("admin").password("admin").roles("ADMIN").authorities("ADMIN");
    }

    @Bean
    public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint(){
        return new CustomBasicAuthenticationEntryPoint();
    }

}


