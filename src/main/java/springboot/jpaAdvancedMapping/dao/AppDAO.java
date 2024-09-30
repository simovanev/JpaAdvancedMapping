package springboot.jpaAdvancedMapping.dao;

import springboot.jpaAdvancedMapping.entity.Instructor;
import springboot.jpaAdvancedMapping.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findById(int id);
    void delete(int id);
    InstructorDetail findDetailById(int id);
    void deleteInstructorDetail(int id);


}
