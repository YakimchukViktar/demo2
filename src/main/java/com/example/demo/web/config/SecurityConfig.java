package com.example.demo.web.config;

import com.example.demo.service.DispatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
private final DispatcherService dispatcherService;
private final BCryptPasswordEncoder bCryptPasswordEncoder;

@Autowired
    public SecurityConfig(DispatcherService dispatcherService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.dispatcherService = dispatcherService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/cars/all", "/cargos/all", "/cargo", "/dispatchers/all", "/drivers/all",
                        "/statusCar/all", "/cars/**")
                .authenticated()
                .and()
                .formLogin()
                .and()
                .authorizeRequests()
                .antMatchers("/","/**")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .usernameParameter("user")
                .passwordParameter("pass")
                .defaultSuccessUrl("/dispatchers/all", true)
                .and()
                .logout().logoutSuccessUrl("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(dispatcherService).passwordEncoder(bCryptPasswordEncoder);
    }
}
