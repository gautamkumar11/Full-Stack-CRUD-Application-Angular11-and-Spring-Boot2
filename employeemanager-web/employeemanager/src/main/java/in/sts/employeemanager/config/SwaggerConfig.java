package in.sts.employeemanager.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final ApiInfo DEFUALT_API_INFO = new ApiInfo(
			"Employee Manager",
			"Api Documentation",
			"1.0", 
			null,
			null, 
			null, 
			null,
			Collections.emptyList());
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("in.sts"))
				.build()
				.apiInfo(DEFUALT_API_INFO);
	}
}
