package br.senac.rn.loja.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
<<<<<<< HEAD
public class WebConfig implements WebMvcConfigurer{
	
	public void addViewController(ViewControllerRegistry controller) {
		controller.addViewController("/login").setViewName("login");		
	}

=======
public class WebConfig implements WebMvcConfigurer {

//	public void addViewController(ViewControllerRegistry registry) {
//		registry.addViewController("/login").setViewName("login");
//	}
	
>>>>>>> 9acd27cf94485285974f67c642867d0a4eb452c3
}
