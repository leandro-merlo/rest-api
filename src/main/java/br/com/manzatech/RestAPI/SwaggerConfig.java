package br.com.manzatech.RestAPI;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket apiConfigDocs() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("br.com.manzatech.RestAPI.resources")).paths(PathSelectors.ant("/api/*")).build();
	}
	
	public ApiInfo infoDocs() {
		return new ApiInfo("Rest API", "Breve Descrição", "1.0", "Termos", new Contact("Leandro Manzano Merlo", "none", "none"), "none", "none", new ArrayList<>());
	}
}
