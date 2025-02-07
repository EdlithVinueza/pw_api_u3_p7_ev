package uce.edu.ec.repository;

import java.lang.reflect.Type;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Typed;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
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

    @Override
    public List<Estudiante> budcarTodos() {
        TypedQuery<Estudiante> query = this.entityManager.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
        return query.getResultList();
    }

    @Override
    public List<Estudiante> buscarPorNombre(String nombre) {
        TypedQuery<Estudiante> query = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.nombre = :nombre", Estudiante.class);
        query.setParameter("nombre", nombre);
        return query.getResultList();
    }

    @Override
    public List<Estudiante> buscarPorNombreYApellido(String nombre, String apellido) {
        TypedQuery<Estudiante> query = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.nombre = :nombre AND e.apellido = :apellido", Estudiante.class);
        query.setParameter("nombre", nombre);
        query.setParameter("apellido", apellido);
        return query.getResultList();
    }

 

}
