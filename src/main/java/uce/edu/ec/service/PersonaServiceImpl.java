package uce.edu.ec.service;

import java.util.List;
import java.util.function.Function;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.repository.IPersonaRepository;
import uce.edu.ec.repository.modelo.Persona;
import uce.edu.ec.service.to.PersonaTo;

@ApplicationScoped // es la que usamos en repository
public class PersonaServiceImpl implements IPersonaService {

    // inyeccion de dependencias
    @Inject
    private IPersonaRepository iPersonaRepository;

    private Function<PersonaTo, Persona> mapTo = p -> {
        Persona persona = new Persona();
        persona.setId(p.getId());
        persona.setNombre(p.getNombre());
        persona.setApellido(p.getApellido());
        persona.setFechaNacimiento(p.getFechaNacimiento());
        return persona;
    };

    private Function<Persona, PersonaTo> mapPersona = p -> {
        PersonaTo personaTo = new PersonaTo();
        personaTo.setId(p.getId());
        personaTo.setNombre(p.getNombre());
        personaTo.setApellido(p.getApellido());
        personaTo.setFechaNacimiento(p.getFechaNacimiento());
        return personaTo;
    };

    @Override
    public PersonaTo buscarPorId(Integer id) {

        Persona persona = this.iPersonaRepository.buscarPorId(id);
        return this.mapPersona.apply(persona);
    }

    @Override
    public void guardar(PersonaTo personaTo) {

        Persona persona = this.mapTo.apply(personaTo);
        this.iPersonaRepository.insertar(persona);
    }

    @Override
    public void actualizar(PersonaTo personaTo) {

        Persona persona = this.mapTo.apply(personaTo);
        this.iPersonaRepository.actualizar(persona);
    }

    @Override
    public void borrar(Integer id) {

        this.iPersonaRepository.eliminar(id);
    }

    @Override
    public List<PersonaTo> buscarTodos() {

        List<Persona> personas = this.iPersonaRepository.buscarTodos();
        return personas.stream().map(this.mapPersona).toList(); // realizamos un mapeo para convertir persona a personaTo
    }


    @Override
    public List<PersonaTo> buscarPorNombre(String nombre) {
        
        List<Persona> personas = this.iPersonaRepository.buscarPorNombre(nombre);
        return personas.stream().map(this.mapPersona).toList();
    }

    @Override
    public List<PersonaTo> buscarPorNombreYApellido(String nombre, String apellido) {
        
        List<Persona> personas = this.iPersonaRepository.buscarPorNombreYApellido(nombre, apellido);
        return personas.stream().map(this.mapPersona).toList();
        
    }

}
