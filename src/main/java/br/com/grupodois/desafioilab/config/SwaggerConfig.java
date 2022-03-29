package br.com.grupodois.desafioilab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
public class SwaggerConfig {

	 @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2)
	          .select()
	          .apis(RequestHandlerSelectors.basePackage("br.com.grupodois.desafioilab"))
	          .paths(PathSelectors.ant("/**"))
	          .build()
//	          .ignoredParameterTypes(DeliveryPerson.class)
	          .apiInfo(apiInfo());
	    }
	 
	 private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .contact(new Contact("Code and Tears", "", ""))
	                .title("Tracking Challenge")
	                .description("Documentação API - Track History - Telemetria dos entregadores do iFood")
	                .version("1.0")
	                .build();
	    }
}

