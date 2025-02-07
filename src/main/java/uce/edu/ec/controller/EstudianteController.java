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
import net.bytebuddy.asm.Advice.This;
import uce.edu.ec.service.IEstudianteService;
import uce.edu.ec.service.to.EstudianteTo;

@Path("/estudiante")
public class EstudianteController {

    @Inject
    private IEstudianteService iEstudianteService;

    @GET
    @Path("{id}")
    public EstudianteTo buscarPorId(@PathParam("id") Integer id) {
        return this.iEstudianteService.buscarPorId(id);
    }
    

    @POST
    @Path("")
    public void guardar(EstudianteTo estudiante) {
        this.iEstudianteService.guardar(estudiante);
    }

    @PUT
    @Path("{id}")
    public void actualizar(EstudianteTo estudiante, @PathParam("id") Integer id) {
        this.iEstudianteService.actualizar(estudiante);
    }

    @PATCH
    @Path("{id}/nuevo/{cedula}")
    public void actualizarParcial(EstudianteTo estudiante, @PathParam("id") Integer id, @PathParam("cedula") String cedula) {
        EstudianteTo tmp = this.iEstudianteService.buscarPorId(id);
        if (estudiante.getNombre() != null) {
            estudiante.setNombre(tmp.getNombre());
        }
        tmp.setNombre(estudiante.getNombre());
        this.iEstudianteService.actualizar(tmp);
    }

    @DELETE
    @Path("{id}")
    public void eliminar(@PathParam("id") Integer id) {
        this.iEstudianteService.eliminar(1);
    }

    @GET
    @Path("")
    public List<EstudianteTo> buscarTodos() {
        return this.iEstudianteService.buscarTodos();
    }   

    @GET
    @Path("/porNombre")
    public List<EstudianteTo> buscarPorNombre(@QueryParam("nombre")String nombre) {
        return this.iEstudianteService.buscarPorNombre(nombre);
    }
    @GET
    @Path("/porNombreYApellido")
    public List<EstudianteTo> buscarPorNombreYApellido(@QueryParam("nombre")String nombre, @QueryParam("apellido")String apellido) {    
        return this.iEstudianteService.buscarPorNombreYApellido(nombre, apellido);
    }





}
