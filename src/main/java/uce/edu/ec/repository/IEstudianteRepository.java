package uce.edu.ec.repository;


import java.util.List;

import uce.edu.ec.repository.modelo.Estudiante;

public interface IEstudianteRepository {
    Estudiante buscarPorId(Integer id);
    Estudiante buscarPorCedula(String cedula);
    void insertar(Estudiante estudiante);
    void actualizar(Estudiante estudiante);
    void eliminar(Integer id);

    List<Estudiante> budcarTodos();
    List<Estudiante> buscarPorNombre(String nombre);
    List<Estudiante> buscarPorNombreYApellido(String nombre, String apellido);

}
