package uce.edu.ec.service;

import uce.edu.ec.service.to.EstudianteTo;

public interface IEstudianteService {

    EstudianteTo buscarPorId(Integer id);
    EstudianteTo buscarPorCedula(String cedula);
    void guardar(EstudianteTo estudiante);
    void actualizar(EstudianteTo estudiante);
    void eliminar(Integer id);

}
