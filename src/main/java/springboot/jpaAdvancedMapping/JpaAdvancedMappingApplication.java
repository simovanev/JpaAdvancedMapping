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
    //todo to fix
//@Bean
//	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
//		return runner -> {
//			createInstructor(appDAO);
//		};
//}

    private void createInstructor(AppDAO appDAO) {
        Instructor instructor = new Instructor("Simo", "Vanev", "test@abv.bg");
        InstructorDetail details = new InstructorDetail("theChannel", "running");
        instructor.setInstructorDetail(details);
        appDAO.save(instructor);
        System.out.println("Save instructor " + instructor);
    }
}
