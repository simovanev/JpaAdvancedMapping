package springboot.jpaAdvancedMapping.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import springboot.jpaAdvancedMapping.entity.Instructor;
import springboot.jpaAdvancedMapping.entity.InstructorDetail;

@Repository
public class AppDAOImpl implements AppDAO{
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
        manager.remove(instructorDetail);
    }
}
