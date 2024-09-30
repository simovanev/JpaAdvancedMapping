package springboot.jpaAdvancedMapping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springboot.jpaAdvancedMapping.dao.AppDAO;
import springboot.jpaAdvancedMapping.entity.Instructor;
import springboot.jpaAdvancedMapping.entity.InstructorDetail;

@Component
public class Initialization implements CommandLineRunner {

    private final AppDAO appDAO;

    public Initialization(AppDAO appDAO) {
        this.appDAO = appDAO;
    }


    @Override
    public void run(String... args) throws Exception {
       // createInstructor(appDAO);
        findInstructor(appDAO);
    }

    private void findInstructor(AppDAO appDAO) {
        Instructor instructor = new Instructor();
        instructor = appDAO.findById(1);
        System.out.println("the id of the instructor is: " + instructor.getId());
        System.out.println("Instructor: " + instructor);
        System.out.println("Instructor Detail: " + instructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {
        Instructor instructor = new Instructor("Gosho", "Peshev", "test@abv.bg");
        InstructorDetail details = new InstructorDetail("theChannel", "running");
        instructor.setInstructorDetail(details);
        appDAO.save(instructor);
        System.out.println("Save instructor " + instructor);
    }

}
