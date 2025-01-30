package uce.edu.ec.service;

import uce.edu.ec.service.to.PersonaTo;

public interface IPersonaService {

    public PersonaTo buscarPorId(Integer id);

    public void guardar(PersonaTo personaTo);

    public void actualizar(PersonaTo personaTo);

    public void borrar(Integer id);

}
