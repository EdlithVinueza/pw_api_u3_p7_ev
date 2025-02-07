package uce.edu.ec.service;

import java.util.List;

import uce.edu.ec.service.to.PersonaTo;

public interface IPersonaService {

    public PersonaTo buscarPorId(Integer id);

    public List<PersonaTo> buscarTodos();

    public List<PersonaTo> buscarPorNombre(String nombre);

    public List<PersonaTo> buscarPorNombreYApellido(String nombre, String apellido);

    public void guardar(PersonaTo personaTo);

    public void actualizar(PersonaTo personaTo);

    public void borrar(Integer id);

}
