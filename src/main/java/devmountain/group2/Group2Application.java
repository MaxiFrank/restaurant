package devmountain.group2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Group2Application {

	public static void main(String[] args) {
		SpringApplication.run(Group2Application.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/availability/").allowedOrigins("*")
						.allowedMethods("GET", "HEAD", "OPTIONS")
						.allowedHeaders("*");
				registry.addMapping("/reservation").allowedOrigins("*")
						.allowedMethods("POST", "HEAD", "OPTIONS")
						.allowedHeaders("*");
			}
		};
	}
}
