package com.spring.javaconfig.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

/**
 * Created by bangae1 on 2016-01-11.
 */
public class WebInitializer implements WebApplicationInitializer {


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.setConfigLocation("com.spring.javaconfig.config");
        applicationContext.register(WebMvcConfig.class);
        applicationContext.register(DataSourceConfig.class);
        servletContext.addListener(new ContextLoaderListener(applicationContext));
        dispatcherServlet(servletContext);
        encodingFilter(servletContext);
    }

    public void dispatcherServlet(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(applicationContext));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
        servlet.setAsyncSupported(true);
    }

    public void encodingFilter(ServletContext servletContext) {
        FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
        EnumSet<DispatcherType> set = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
        filter.addMappingForUrlPatterns(set,false, "/*");
    }
}
