package com.akhm;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableFeignClients


public class RentalWebAppApplication extends SpringBootServletInitializer implements WebMvcConfigurer {
public static void main(String[] args) {
		SpringApplication.run(RentalWebAppApplication.class, args);
	}

@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		
		converters.add(new MappingJackson2HttpMessageConverter());
	
		

}
@Bean
public RestTemplate getRestTemplate()
{
	return new RestTemplate();
	
}

@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		
		return builder.sources(RentalWebAppApplication.class);
	}

}
