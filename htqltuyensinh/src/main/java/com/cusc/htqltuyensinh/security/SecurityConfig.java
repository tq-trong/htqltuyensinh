package com.cusc.htqltuyensinh.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cusc.htqltuyensinh.config.Constants;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
    public CustomAuthenticationFailureHandler customAuthenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	.cors().and().csrf().disable()
            .authorizeRequests()
                .antMatchers("/api/**").permitAll()
                .antMatchers("/usermanager").hasAnyRole("USERMANAGER")
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage(Constants.SERVER_PORT_FRONTEND + "/login/")
                .defaultSuccessUrl("/home")
                .failureHandler(customAuthenticationFailureHandler())
                .permitAll()
                .and()
            .logout()
                .permitAll();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
