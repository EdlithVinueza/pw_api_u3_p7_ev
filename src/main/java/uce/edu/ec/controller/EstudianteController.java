package uce.edu.ec.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import uce.edu.ec.service.IEstudianteService;
import uce.edu.ec.service.to.EstudianteTo;

@Path("/estudiante")
public class EstudianteController {

    @Inject
    private IEstudianteService iEstudianteService;

    @GET
    @Path("/buscar-por-id")
    public EstudianteTo buscarPorId() {
        Integer id = 1;
        return this.iEstudianteService.buscarPorId(id);

    }
    @GET
    @Path("/buscar-por-cedula")
    public EstudianteTo buscarPorCedula() {
        String cedula = "1234567890";
        return this.iEstudianteService.buscarPorCedula(cedula);
    }

    @POST
    @Path("/guardar")
    public void guardar(EstudianteTo estudiante) {
        this.iEstudianteService.guardar(estudiante);
    }

    @PUT
    @Path("/actualizar")
    public void actualizar(EstudianteTo estudiante) {
        this.iEstudianteService.actualizar(estudiante);
    }

    @PATCH
    @Path("/actualizar/parcial")
    public void actualizarParcial(EstudianteTo estudiante) {
        EstudianteTo tmp = this.iEstudianteService.buscarPorId(estudiante.getId());
        if (estudiante.getNombre() != null) {
            estudiante.setNombre(tmp.getNombre());
        }
        tmp.setNombre(estudiante.getNombre());
        this.iEstudianteService.actualizar(tmp);
    }

    @DELETE
    @Path("/borrar")
    public void eliminar() {
        this.iEstudianteService.eliminar(1);
    }



}
