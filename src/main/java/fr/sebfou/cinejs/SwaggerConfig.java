package fr.sebfou.cinejs;

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

/**
 * Created by seb_f on 30/12/2016.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public SwaggerConfig() {
        super();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("cinejs")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("CineJS with Swagger")
                .description("Spring Mongo REST with Swagger for CineJS Application")
                .termsOfServiceUrl("http://springfox.io")
                .contact(new Contact("Sebastien F", "https://github.com/sfoubert", "seb_fou@hotmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/sfoubert/cinejs/blob/master/LICENSE")
                .version("2.0")
                .build();
    }

}
