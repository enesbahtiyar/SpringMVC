package com.eb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan //("com.eb")
public class WebMvcConfig implements WebMvcConfigurer
{
    @Bean
    public InternalResourceViewResolver resolver()
    {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        //setting the view class to .jsp
        resolver.setViewClass(JstlView.class);
        //specify the folder to check for views
        resolver.setPrefix("/WEB-INF/views/");
        //specify the extension
        resolver.setSuffix(".jsp");
        return resolver;
    }

    //specifying the resources that'll be used for my front-end
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        //find the resources from the path
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/")
                .setCachePeriod(0);  //giving a period time for caching
    }
}
