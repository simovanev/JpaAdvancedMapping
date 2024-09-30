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
        //findInstructor(appDAO);
        //deleteInstructor(appDAO);
        //findInstructorDetailsById(appDAO);
        deleteDetails(appDAO);
    }

    private void deleteDetails(AppDAO appDAO) {
        int id=1;
        System.out.println("Details to be deleted: "+id);
        appDAO.deleteInstructorDetail(1);
        System.out.println("Done!");
    }

    private void findInstructorDetailsById(AppDAO appDAO) {
        int id=1;
        System.out.println("The id is: "+id);
        InstructorDetail detailById = appDAO.findDetailById(id);
        System.out.println("The details are: "+detailById);
        System.out.println("The instructor is: "+detailById.getInstructor());
    }

    private void deleteInstructor(AppDAO appDAO) {
        int id=2;
        System.out.println("Deleting instructor by id: "+id);
        appDAO.delete(id);
        System.out.println("Done!");
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
