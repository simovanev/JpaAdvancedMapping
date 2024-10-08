package springboot.jpaAdvancedMapping.dao;

import springboot.jpaAdvancedMapping.entity.Course;
import springboot.jpaAdvancedMapping.entity.Instructor;
import springboot.jpaAdvancedMapping.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findById(int id);
    void delete(int id);
    InstructorDetail findDetailById(int id);
    void deleteInstructorDetail(int id);
    List<Course> findCoursesByInstructorId(int id);
    void update(Instructor instructor);
    Course findCourseById(int id);
    void updateCourse(Course course);
    void saveCourse(Course course);
    Course findCourseAndReviewsById(int id);


}
