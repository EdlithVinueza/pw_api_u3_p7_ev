package uce.edu.ec.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce.edu.ec.service.IPersonaService;
import uce.edu.ec.service.to.PersonaTo;

@Path("/persona") // Definimos el nombre del servicio
public class PersonaController {

    // Crear los metodos de la funcionadlidad de la clase Persona
    @Inject
    private IPersonaService iPersonaService;

    @GET
    @Path("/{id}") // definimso nombre de la capacida
    public PersonaTo buscarPorId(@PathParam("id") Integer id) {
        return this.iPersonaService.buscarPorId(id);
    }

    @POST
    @Path("") // definimso nombre de la capacida
    public void guardar(PersonaTo personaTo) {
        this.iPersonaService.guardar(personaTo);
    }

    @PUT
    @Path("/{id}") // definimso nombre de la capacida
    public void actualizar(PersonaTo personaTo, @PathParam("id") Integer id) { //debemos recibir un objeto to
        PersonaTo tmp = this.iPersonaService.buscarPorId(id);
        tmp.setNombre(personaTo.getNombre());
        this.iPersonaService.actualizar(tmp);
    }

    @PATCH
    @Path("/{id}/nuevo/{cedula}") // definimso nombre de la capacida
    public void actualizarParcial(PersonaTo personaTo,  @PathParam("id") Integer id,@PathParam("cedula") String cedula) { //debemos recibir un objeto to 
        System.out.println("Cedula: "+cedula);
        PersonaTo tmp = this.iPersonaService.buscarPorId(id);
        if (personaTo.getNombre() != null) {
            personaTo.setNombre(tmp.getNombre());
        }
        tmp.setNombre(personaTo.getNombre());
        this.iPersonaService.actualizar(tmp);
    }

    @DELETE
    @Path("/{id}") // definimso nombre de la capacida
    public void borrar(@PathParam("id") Integer id) {
        this.iPersonaService.borrar(id);
    }

}
