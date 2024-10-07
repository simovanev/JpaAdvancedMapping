package springboot.jpaAdvancedMapping.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import springboot.jpaAdvancedMapping.entity.Course;
import springboot.jpaAdvancedMapping.entity.Instructor;
import springboot.jpaAdvancedMapping.entity.InstructorDetail;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {
    private final EntityManager manager;

    public AppDAOImpl(EntityManager manager) {
        this.manager = manager;
    }


    @Override
    @Transactional
    public void save(Instructor instructor) {
        manager.persist(instructor);
    }

    @Override
    public Instructor findById(int id) {
        return manager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Instructor byId = findById(id);
        List<Course> courses = byId.getCourses();
        for (Course course : courses) {
            course.setInstructor(null);
        }
        manager.remove(byId);
    }

    @Override
    public InstructorDetail findDetailById(int id) {
        return manager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetail(int id) {
        InstructorDetail instructorDetail = findDetailById(id);
        instructorDetail.getInstructor().setInstructorDetail(null);
        manager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query = manager.createQuery(
                "SELECT c FROM Course c WHERE c.instructor.id=:id", Course.class);
        query.setParameter("id", id);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        manager.merge(instructor);
    }

    @Override
    public Course findCourseById(int id) {
       return manager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        manager.merge(course);
    }

    @Override
    @Transactional
    public void saveCourse(Course course) {
        manager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsById(int id) {
        TypedQuery<Course> query= manager.createQuery("SELECT c from Course c " +
                "JOIN FETCH c.reviews where c.id=:data", Course.class);
        return query.setParameter("data", id).getSingleResult();
    }
}
