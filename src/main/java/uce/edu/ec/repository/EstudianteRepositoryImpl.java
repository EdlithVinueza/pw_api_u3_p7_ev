package uce.edu.ec.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import uce.edu.ec.repository.modelo.Estudiante;

@Transactional
@ApplicationScoped 
public class EstudianteRepositoryImpl implements IEstudianteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Estudiante buscarPorId(Integer id) {
        
        return this.entityManager.find(Estudiante.class, id);
    }

    @Override
    public Estudiante buscarPorCedula(String cedula) {
        
        return this.entityManager.find(Estudiante.class, cedula);
    }

    @Override
    public void insertar(Estudiante estudiante) {
        
        this.entityManager.persist(estudiante);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        
        this.entityManager.merge(estudiante);
    }

    @Override
    public void eliminar(Integer id) {
        
        this.entityManager.remove(this.buscarPorId(id));
    }

}
