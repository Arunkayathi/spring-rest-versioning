package com.demo.springfoxexample.config;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static com.google.common.base.Predicates.or;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
@PropertySource("classpath:swagger.properties")
public class SpringFoxConfig {

    @Bean
    public Docket swaggerPersonApiV1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("demorestapi-1.0")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.demo"))
                .paths(paths())
                .build()
                .apiInfo(getApiInfo());
    }

    private Predicate<String> paths() {
        return or(PathSelectors.regex("/api/v1.*"));
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "SpringFox Demo Application",
                "This application demonstrates documenting os Spring Boot app with Swagger using SpringFox.",
                "1.0.0",
                "TERMS OF SERVICE URL",
                new Contact("Arun", "http://www.kroger.com", "arun.reddy@kroger.com"),
                "MIT License",
                "LICENSE URL",
                Collections.emptyList()
        );
    }

    @Bean
    public Docket swaggerPersonApiV2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("demorestapi-2.0")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.demo"))
                .paths(PathSelectors.ant("/api/v2/**"))
                .build()
                //.pathMapping("/api/v2")
                .produces(Sets.newHashSet(APPLICATION_JSON_VALUE))
                .consumes(Sets.newHashSet(APPLICATION_JSON_VALUE))
                .apiInfo(getApiInfo());
    }

}
