package com.scai.esercizioPizza.configuration;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "it.scai.pizzaweb")
@PropertySource({"classpath:application.properties"})
public class SpringConfig extends WebSecurityConfigurerAdapter{

	  @Bean
	    public CorsFilter corsFilter() {
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        
	        CorsConfiguration config = new CorsConfiguration();
	        config.setAllowCredentials(true);
	        config.addAllowedOrigin("*");
	        config.addAllowedHeader("*");
	        config.addAllowedMethod("OPTIONS");
	        config.addAllowedMethod("GET");
	        config.addAllowedMethod("POST");
	        config.addAllowedMethod("PUT");
	        config.addAllowedMethod("DELETE");
	        source.registerCorsConfiguration("*", config);
	        
	        return new CorsFilter(source);
	    }
	   
	  @Bean
	   public InternalResourceViewResolver resolver() {
	      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	      resolver.setPrefix("/WEB-INF/jsp/");
	      resolver.setSuffix(".jsp");
	      return resolver;
	   }
	   
	   @Override
	   protected void configure(HttpSecurity http) throws Exception {

	       //...         
		   http			
	    	.sessionManagement()
	    	//	.invalidSessionUrl("/login")
	    		.sessionFixation()
	    			.newSession()
	    				.maximumSessions(1);
		   
		  
		   http.csrf().disable();
	       http.cors().configurationSource(new CorsConfigurationSource() {

	    	   
	    	   
	        @Override
	        public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
	            CorsConfiguration config = new CorsConfiguration();
	            config.setAllowedHeaders(Collections.singletonList("*"));
	            config.setAllowedMethods(Collections.singletonList("*"));
	            config.addAllowedOrigin("*");
	            config.setAllowCredentials(true);
	            return config;
	        }
	      });
	   }
	   
	   
	   @Bean
	   HeaderHttpSessionStrategy sessionStrategy() {
	     return new HeaderHttpSessionStrategy();
	   }
	   
	   @Bean
	   public ModelMapper modelMapper() {
	       return new ModelMapper();
	   }
	   
	   @Bean
	   public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
	       ObjectMapper mapper = new ObjectMapper();
	       mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	       MappingJackson2HttpMessageConverter converter = 
	           new MappingJackson2HttpMessageConverter(mapper);
	       return converter;
	   }

}
