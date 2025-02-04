package uce.edu.ec.service;

import java.util.function.Function;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.repository.IEstudianteRepository;
import uce.edu.ec.repository.modelo.Estudiante;
import uce.edu.ec.service.to.EstudianteTo;

@ApplicationScoped
public class EstudianteServiceImpl implements IEstudianteService {

    @Inject
    private IEstudianteRepository iEstudianteRepository;

    private Function<EstudianteTo, Estudiante> mapTo = e -> {
        Estudiante estudiante = new Estudiante();
        estudiante.setId(e.getId());
        estudiante.setNombre(e.getNombre());
        estudiante.setApellido(e.getApellido());
        estudiante.setCedula(e.getCedula());
       estudiante.setEmail(e.getEmail());
        return estudiante;
    };

    private Function<Estudiante, EstudianteTo> mapEstudiante = e -> {
        EstudianteTo estudianteTo = new EstudianteTo();
        estudianteTo.setId(e.getId());
        estudianteTo.setNombre(e.getNombre());
        estudianteTo.setApellido(e.getApellido());
        estudianteTo.setCedula(e.getCedula());
        estudianteTo.setEmail(e.getEmail());
        return estudianteTo;
    };

    @Override
    public EstudianteTo buscarPorId(Integer id) {
      
        Estudiante estudiante = this.iEstudianteRepository.buscarPorId(id);
        return this.mapEstudiante.apply(estudiante);
     }

    @Override
    public EstudianteTo buscarPorCedula(String cedula) {
        
        Estudiante estudiante = this.iEstudianteRepository.buscarPorCedula(cedula);
        return this.mapEstudiante.apply(estudiante);
    }

    @Override
    public void guardar(EstudianteTo estudiante) {
        Estudiante estudiante1 = this.mapTo.apply(estudiante);
        this.iEstudianteRepository.insertar(estudiante1);
    }

    @Override
    public void actualizar(EstudianteTo estudiante) {
        Estudiante estudiante1 = this.mapTo.apply(estudiante);
        this.iEstudianteRepository.actualizar(estudiante1);
    }

    @Override
    public void eliminar(Integer id) {
        this.iEstudianteRepository.eliminar(id);
    }

}
