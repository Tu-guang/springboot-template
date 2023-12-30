package com.tuguang.template.config;

import com.tuguang.template.aop.AuthorizationInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Bean
    public AuthorizationInterceptor getAuthorizationInterceptor() {
        return new AuthorizationInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] excludePatterns = new String[]{"/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui/**",
                "/api-docs", "/api-docs/**", "/doc.html/**", "/v3/api-docs"};
        registry.addInterceptor(getAuthorizationInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/register")
                .excludePathPatterns(excludePatterns);
        super.addInterceptors(registry);
    }

    /**
     * springboot 2.0配置WebMvcConfigurationSupport之后，会导致默认配置被覆盖，要访问静态资源需要重写addResourceHandlers方法
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**");
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/favicon.ico").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }


}
