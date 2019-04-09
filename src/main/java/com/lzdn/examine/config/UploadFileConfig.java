package com.lzdn.examine.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.annotation.MultipartConfig;

@Configuration
public class UploadFileConfig implements WebMvcConfigurer {
//    @Value("${vocs.user.fileUpload.rootSavePath}")
//    private String rootSavePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("file:/home/upload/sign/");
        registry.addResourceHandler("/images/**").addResourceLocations("file:D:/home/upload/sign/");
        registry.addResourceHandler("/OTA/**").addResourceLocations("file:/home/upload/sign/");
    }
}
