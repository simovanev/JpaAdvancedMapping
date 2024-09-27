package springboot.jpaAdvancedMapping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springboot.jpaAdvancedMapping.dao.AppDAO;
import springboot.jpaAdvancedMapping.entity.Instructor;
import springboot.jpaAdvancedMapping.entity.InstructorDetail;

@SpringBootApplication
public class JpaAdvancedMappingApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaAdvancedMappingApplication.class, args);
    }

}
