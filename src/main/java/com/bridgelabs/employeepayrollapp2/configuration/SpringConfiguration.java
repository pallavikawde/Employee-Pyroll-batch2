package com.bridgelabs.employeepayrollapp2.configuration;

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
 * Purpose : To configure the SWAGGER2 documentation for employee payroll service application
 *
 * @author pallavi jagtap
 * @version : 0.0.1-SNAPSHOT
 * @since 2021-12-15
 */
@Configuration
@EnableSwagger2
public class SpringConfiguration {

    /**
     * Purpose : This method is used to specify the swagger to which API(Application Programming Interface)
     * to show on Swagger UI(User Interface) console
     *
     * @return the docket link which has the information about API(Application Programming Interface)
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bridgelabs.employeepayrollapp2.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metadata());
    }

    /**
     * Purpose : This method is used to add extra datas which will give user a proper idea about
     * the API(Application Programming Interface) information in the Swagger UI(User Interface) console
     *
     * @return the swagger API information
     */
    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title(" EmployeePayroll Application API")
                .description("\"Swagger configuration for application testing\"")
                .version("0.0.1")
                .license("Apache 2.0 (example)")
                .licenseUrl("if there will be any")
                .contact(new Contact("pallavi", "www.facebook.com", "pallavi@gmail.com"))
                .build();
    }
}

