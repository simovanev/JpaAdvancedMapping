package springboot.jpaAdvancedMapping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaAdvancedMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaAdvancedMappingApplication.class, args);
	}
@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Welcome to Jpa Advanced Mapping");
		};
}
}
