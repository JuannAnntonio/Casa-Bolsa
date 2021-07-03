package com.phi.proyect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ProyectApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ProyectApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ProyectApplication.class, args);
    }
    
//    @EnableWebSecurity
//    @Configuration
//    class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http.csrf().disable()
//                    .cors().and()
//                    .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
//                    .authorizeRequests()
//                    .antMatchers(HttpMethod.POST, "/admin/**").hasRole("ADMIN")
//                    .antMatchers(HttpMethod.GET, "/**").permitAll()
//                    .anyRequest().authenticated();
//        }
//    }
    
    
}
