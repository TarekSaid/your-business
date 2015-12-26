package br.com.tarek.your.business.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * Created by tarek on 07/12/15.
 */
@Configuration
@EnableWebMvc
@ComponentScan("br.com.tarek.your.business.controllers")
public class WebappConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
  }

  @Bean
  public ViewResolver viewResolver() {
    FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();

    viewResolver.setPrefix("");
    viewResolver.setSuffix(".ftl");
    viewResolver.setCache(true);
    viewResolver.setContentType("text/html;charset=utf-8");

    return viewResolver;
  }

  @Bean
  public FreeMarkerConfigurer freeMarkerConfig() {
    FreeMarkerConfigurer config = new FreeMarkerConfigurer();
    config.setTemplateLoaderPath("/views/");
    return config;
  }
}
