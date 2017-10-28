package com.hackcrashfiasco.letMeComplainFiasco;

import com.hackcrashfiasco.letMeComplainFiasco.filter.AuthorisationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class LetMeComplainFiascoApplication extends WebMvcConfigurerAdapter {

	@Autowired
    AuthorisationInterceptor authorisationInteceptor;

	public static void main(String[] args) {
		SpringApplication.run(LetMeComplainFiascoApplication.class, args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authorisationInteceptor);
	}

}
