package com.demo.SalaryInfoApi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class CustomerSwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Customer Info").apiInfo(apiInfo()).select()
				.paths(regex("/customer.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Customer Service")
				.description("Sample Documentation Generateed Using SWAGGER2 for our Customer Rest API")
				.termsOfServiceUrl("http://localhost:8080")
				.license("Customer License")
				.licenseUrl("https://www.google.com").version("1.0").build();
	}
}
