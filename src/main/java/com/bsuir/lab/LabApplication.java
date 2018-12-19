package com.bsuir.lab;

import com.bsuir.lab.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@SpringBootApplication
public class LabApplication {

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/api/regions/*");
        registrationBean.addUrlPatterns("/api/dataRegister/*");
        registrationBean.addUrlPatterns("/api/sensors/*");
        registrationBean.addUrlPatterns("/api/utils/getAll");

        return registrationBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(LabApplication.class, args);
    }
}

