package com.demo.web.config;

import com.demo.service.DispatcherService;
import com.demo.service.DriverService;
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
    private final DriverService driverService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public SecurityConfig(DispatcherService dispatcherService, DriverService driverService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.dispatcherService = dispatcherService;
        this.driverService = driverService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/trips/all").hasAnyAuthority("ROLE_DISPATCHER", "ROLE_ADMIN", "ROLE_DRIVER")
                .antMatchers("/drivers/**", "/statusCar/all", "/cargos/all",
                        "/cargo", "/cars/**").hasAnyAuthority("ROLE_DISPATCHER", "ROLE_ADMIN")
                .antMatchers("/dispatchers/**", "/registerDispatcher").hasAnyAuthority("ROLE_ADMIN")
                .and()
                .formLogin()
                .and()
                .authorizeRequests()
                .antMatchers("/", "/**")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .usernameParameter("user")
                .passwordParameter("pass")
                .defaultSuccessUrl("/trips/all", true)
                .and()
                .logout().logoutSuccessUrl("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(dispatcherService).passwordEncoder(bCryptPasswordEncoder);
        auth.userDetailsService(driverService).passwordEncoder(bCryptPasswordEncoder);
    }
}
