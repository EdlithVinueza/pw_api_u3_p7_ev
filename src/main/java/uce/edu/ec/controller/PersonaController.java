package uce.edu.ec.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
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
    public PersonaTo buscarPorId() {
        Integer id = 1;
        return this.iPersonaService.buscarPorId(id);

    }

    @POST
    @Path("/guardar") // definimso nombre de la capacida
    public void guardar(PersonaTo personaTo) {
        this.iPersonaService.guardar(personaTo);
    }

    @PUT
    @Path("/actualizar") // definimso nombre de la capacida
    public void actualizar(PersonaTo personaTo) {
        this.iPersonaService.actualizar(personaTo);
    }

    @PATCH
    @Path("/actualizar/parcial") // definimso nombre de la capacida
    public void actualizarParcial(PersonaTo personaTo) { //debemos recibir un objeto to 
        PersonaTo tmp = this.iPersonaService.buscarPorId(personaTo.getId());
        if (personaTo.getNombre() != null) {
            personaTo.setNombre(tmp.getNombre());
        }
        tmp.setNombre(personaTo.getNombre());
        this.iPersonaService.actualizar(tmp);
    }

    @DELETE
    @Path("/borrar") // definimso nombre de la capacida
    public void borrar() {
        this.iPersonaService.borrar(1);
    }

}
