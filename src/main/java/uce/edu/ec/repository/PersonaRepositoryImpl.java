package uce.edu.ec.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.ec.repository.modelo.Persona;

@Transactional
@ApplicationScoped // En lugar de repository de SpirngBoot
public class PersonaRepositoryImpl implements IPersonaRepository {

    // Aqui se hace la inyeccion de depenendiacias
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Persona buscarPorId(Integer id) {
         try {
            return this.entityManager.find(Persona.class, id);
        } catch (Exception e) {
            System.out.println("Error al buscar por id: " + e.getMessage());
            return new Persona(0, "No existe", "No existe", null);
        }
    }

    @Override
    public void insertar(Persona persona) {
        this.entityManager.persist(persona);

    }

    @Override
    public void actualizar(Persona persona) {
        this.entityManager.merge(persona);

    }

    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(this.buscarPorId(id));

    }

    @Override
    public List<Persona> buscarTodos() {
       TypedQuery<Persona> mQuery= this.entityManager.createQuery("SELECT p FROM Persona p", Persona.class);
        return mQuery.getResultList();
    }

    @Override
    public List<Persona> buscarPorNombre(String nombre) {
        TypedQuery<Persona> mQuery= this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.nombre = :nombre", Persona.class);
        mQuery.setParameter("nombre", nombre);
        return mQuery.getResultList();
    }

    @Override
    public List<Persona> buscarPorNombreYApellido(String nombre, String apellido) {
        
        TypedQuery<Persona> mQuery= this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.nombre = :nombre AND p.apellido = :apellido", Persona.class);
        mQuery.setParameter("nombre", nombre);
        mQuery.setParameter("apellido", apellido);
        return mQuery.getResultList();
    }

}
