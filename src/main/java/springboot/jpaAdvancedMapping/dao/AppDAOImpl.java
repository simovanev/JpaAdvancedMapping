package springboot.jpaAdvancedMapping.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import springboot.jpaAdvancedMapping.entity.Instructor;
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
}
