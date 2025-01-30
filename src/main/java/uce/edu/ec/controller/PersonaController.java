package uce.edu.ec.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import uce.edu.ec.service.IPersonaService;
import uce.edu.ec.service.to.PersonaTo;

@Path("/persona") // Definimos el nombre del servicio
public class PersonaController {

    // Crear los metodos de la funcionadlidad de la clase Persona
    @Inject
    private IPersonaService iPersonaService;

    @GET
    @Path("/buscar") // definimso nombre de la capacida
    public void buscarPorId() {
        Integer id = 1;
        this.iPersonaService.buscarPorId(id);
    }

    @GET
    @Path("/guardar") // definimso nombre de la capacida
    public void guardar(PersonaTo personaTo) {
        this.iPersonaService.guardar(personaTo);
    }

    @GET
    @Path("/actualizar") // definimso nombre de la capacida
    public void actualizar(PersonaTo personaTo) {
        this.iPersonaService.actualizar(personaTo);
    }

    @GET
    @Path("/borrar") // definimso nombre de la capacida
    public void borrar(Integer id) {
        this.iPersonaService.borrar(id);
    }

}
