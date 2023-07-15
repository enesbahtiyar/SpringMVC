package com.eb;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//instead of web.xml we had earlier we are going to use this class for configuration
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

    //getting the configuration related to the hibernate and database
    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class[]
                {
                        RootContextConfig.class
                };
    }

    //MVC configurations
    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        return new Class[]
                {
                        WebMvcConfig.class
                };
    }

    //Which url would go to which servlet
    @Override
    protected String[] getServletMappings()
    {
        return new String[]
        {
                "/"
        };
    }
}
