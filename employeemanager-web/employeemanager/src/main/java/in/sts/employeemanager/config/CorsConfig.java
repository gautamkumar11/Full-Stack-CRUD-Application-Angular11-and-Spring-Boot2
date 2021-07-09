package in.sts.employeemanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

	@Bean
	public WebMvcConfigurer getCorsConfiguration(){
		
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:4200")
						.allowCredentials(true)
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
						.allowedHeaders("Origin", "Access-Control-Allow-Origin", "Content-Type",
								"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
								"Access-Control-Request-Method", "Access-Control-Request-Headers");
			}
		};
	}
	
}
