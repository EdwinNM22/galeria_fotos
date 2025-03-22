package com.edwin.galeriademo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceWebConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Mapea las rutas /images/** a una carpeta fuera del proyecto
        registry.addResourceHandler("/images/**").addResourceLocations("file:images/");
    }
}
