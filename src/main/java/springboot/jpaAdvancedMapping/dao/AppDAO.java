package springboot.jpaAdvancedMapping.dao;

import springboot.jpaAdvancedMapping.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findById(int id);


}
