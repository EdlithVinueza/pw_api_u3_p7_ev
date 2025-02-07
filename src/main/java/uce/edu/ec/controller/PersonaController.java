package uce.edu.ec.controller;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import uce.edu.ec.service.IPersonaService;
import uce.edu.ec.service.to.PersonaTo;

@Path("/persona") // Definimos el nombre del servicio
public class PersonaController {

    
    @Inject
    private IPersonaService iPersonaService;

    @GET
    @Path("/{id}") 
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
    @Path("/{id}/nuevo/{cedula}")
    public void actualizarParcial(PersonaTo personaTo, @PathParam("id") Integer id, @PathParam("cedula") String cedula) {
        System.out.println("Cedula: " + cedula);
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
