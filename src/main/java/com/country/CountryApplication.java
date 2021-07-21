package com.country;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.country.bean.State;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.Collections;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CountryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountryApplication.class, args);
		System.out.println("My Spring Boot Application testing...");
		State stObj = new State();
		
	}
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/country/*"))
				.apis(RequestHandlerSelectors.basePackage("com.country"))
				.build()
				.apiInfo(apiDetails());
	}
	private ApiInfo apiDetails() {
		return new ApiInfo("Country API",
		"Sample APIs for practice",
		"1.0",
		"Free to Use",
		new springfox.documentation.service.Contact("Prateeva Polai", "https://javabrain.io", "prateevapolai@gmail.com"),
		"API License",
		"https://javabrain.io",
		java.util.Collections.emptyList());
	}
}
