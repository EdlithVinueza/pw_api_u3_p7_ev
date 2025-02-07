package uce.edu.ec.service;

import java.util.List;

import uce.edu.ec.service.to.EstudianteTo;

public interface IEstudianteService {

    EstudianteTo buscarPorId(Integer id);
    EstudianteTo buscarPorCedula(String cedula);
    void guardar(EstudianteTo estudiante);
    void actualizar(EstudianteTo estudiante);
    void eliminar(Integer id);

    List<EstudianteTo> buscarTodos();
    List<EstudianteTo> buscarPorNombre(String nombre);
    List<EstudianteTo> buscarPorNombreYApellido(String nombre, String apellido);

}
