package springboot.jpaAdvancedMapping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springboot.jpaAdvancedMapping.dao.AppDAO;
import springboot.jpaAdvancedMapping.entity.Instructor;
import springboot.jpaAdvancedMapping.entity.InstructorDetail;

@Component
public class Initialization implements CommandLineRunner {

    private AppDAO appDAO;

    @Override
    public void run(String... args) throws Exception {
        Instructor instructor = new Instructor("Simo", "Vanev", "test@abv.bg");
        InstructorDetail details = new InstructorDetail("theChannel", "running");
        instructor.setInstructorDetail(details);
        appDAO.save(instructor);
        System.out.println("Save instructor " + instructor);createInstructor(appDAO);
    }

    private void createInstructor(AppDAO appDAO) {

    }

}
