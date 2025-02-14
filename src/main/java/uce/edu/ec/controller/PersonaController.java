package uce.edu.ec.controller;

import java.util.List;

import jakarta.ws.rs.Produces;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uce.edu.ec.service.IPersonaService;
import uce.edu.ec.service.to.PersonaTo;

@Path("/persona") // Definimos el nombre del servicio
public class PersonaController {

    
    @Inject
    private IPersonaService iPersonaService;

    @GET
    @Path("/{id}") 
    @Produces(MediaType.APPLICATION_XML) // esto produce o retorna algo 
    public Response buscarPorId(@PathParam("id") Integer id) {
        //Si queremos enviar mensajes o codigos de respuesta los mandamos desde el header
        return Response.status(240).header("mensaje", "Persona creada pero en proceso de validación...").header("valor1", 500).entity(this.iPersonaService.buscarPorId(id)).build();
    }

    @POST
    @Path("") // definimso nombre de la capacida
    @Consumes(MediaType.APPLICATION_XML)
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
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public void actualizarParcial(PersonaTo personaTo, @PathParam("id") Integer id) {
        PersonaTo tmp = this.iPersonaService.buscarPorId(id);
        if (personaTo.getNombre() != null) {
            personaTo.setNombre(tmp.getNombre());
        }
        tmp.setNombre(personaTo.getNombre());
        this.iPersonaService.actualizar(tmp);
        Response.status(200).header("mensaje", "Persona actualizada").entity(tmp).build();
    }

    @DELETE
    @Path("/{id}") // definimso nombre de la capacida
    public void borrar(@PathParam("id") Integer id) {
        this.iPersonaService.borrar(id);
    }

    
    @GET
    @Path("")
    public List<PersonaTo> buscarTodos(){
        return this.iPersonaService.buscarTodos(); 
    }
    
    @GET
    @Path("/porNombre") //por que si no se confunde con el el path de buscarTodos
    public List<PersonaTo> buscarPorNombre(@QueryParam("nombre") String nombre){
        return this.iPersonaService.buscarPorNombre(nombre);
    }

    @GET
    @Path("porNombreYApellido") 
    public List<PersonaTo> buscarPorNombreYApellidos(@QueryParam("nombre") String nombre, @QueryParam("apellido") String apellido) {
        return this.iPersonaService.buscarPorNombreYApellido(nombre, apellido);
    }

}
