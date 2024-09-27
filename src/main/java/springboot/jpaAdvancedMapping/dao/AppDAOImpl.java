package springboot.jpaAdvancedMapping.dao;

import jakarta.persistence.EntityManager;
import springboot.jpaAdvancedMapping.entity.Instructor;

public class AppDAOImpl implements AppDAO{
    private final EntityManager manager;

    public AppDAOImpl(EntityManager manager) {
        this.manager = manager;
    }


    @Override
    public void save(Instructor instructor) {
        manager.persist(instructor);
    }
}
