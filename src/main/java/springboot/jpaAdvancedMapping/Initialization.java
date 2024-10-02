package springboot.jpaAdvancedMapping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springboot.jpaAdvancedMapping.dao.AppDAO;
import springboot.jpaAdvancedMapping.entity.Course;
import springboot.jpaAdvancedMapping.entity.Instructor;
import springboot.jpaAdvancedMapping.entity.InstructorDetail;

import java.util.List;

@Component
public class Initialization implements CommandLineRunner {

    private final AppDAO appDAO;

    public Initialization(AppDAO appDAO) {
        this.appDAO = appDAO;
    }


    @Override
    public void run(String... args) throws Exception {
        //createInstructor(appDAO);
        //findInstructor(appDAO);
        //deleteInstructor(appDAO);
        //findInstructorDetailsById(appDAO);
        //deleteDetails(appDAO);
        //createInstructorWithCourses(appDAO);
        //extractInstructorDetails(appDAO);
        findCoursesById(appDAO);
    }

    private void findCoursesById(AppDAO appDAO) {
        int id = 1;
        Instructor instructor = appDAO.findById(id);
        System.out.println("Instructor: " + instructor);
        List<Course> theCourses = appDAO.findCoursesByInstructorId(id);
        System.out.println("Courses: " + theCourses);
        instructor.setCourses(theCourses);
        System.out.println("Done!");
    }

    private void extractInstructorDetails(AppDAO appDAO) {
        int id = 1;
        Instructor instructor = appDAO.findById(id);
        System.out.println("The id is: " + id);
        System.out.println("The instructor details are: " + instructor);
        System.out.println("The course details are: " + instructor.getCourses());
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        Instructor instructor = new Instructor("Dichko", "Hristov", "test@abv.bg");
        InstructorDetail details = new InstructorDetail("theChannel", "running");
        instructor.setInstructorDetail(details);
        Course c1 = new Course("Java");
        Course c2 = new Course("JavaScript");
        Course c3 = new Course("Python");
        Course c4 = new Course("c#");
        instructor.addCourse(c1);
        instructor.addCourse(c2);
        instructor.addCourse(c3);
        instructor.addCourse(c4);
        System.out.println("Save instructor " + instructor);
        System.out.println("Save courses " + instructor.getCourses());
        appDAO.save(instructor);
        System.out.println("Done!");
    }

    private void deleteDetails(AppDAO appDAO) {
        int id = 3;
        System.out.println("Details to be deleted: " + id);
        appDAO.deleteInstructorDetail(id);
        System.out.println("Done!");
    }

    private void findInstructorDetailsById(AppDAO appDAO) {
        int id = 1;
        System.out.println("The id is: " + id);
        InstructorDetail detailById = appDAO.findDetailById(id);
        System.out.println("The details are: " + detailById);
        System.out.println("The instructor is: " + detailById.getInstructor());
    }

    private void deleteInstructor(AppDAO appDAO) {
        int id = 2;
        System.out.println("Deleting instructor by id: " + id);
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
