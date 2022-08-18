package ec.edu.espe.colegioservidor.repository;

import ec.edu.espe.colegioservidor.model.Estudiante;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstudianteRepository extends MongoRepository<Estudiante, String> {
  List<Estudiante> findByNivelOrderByCedula(Integer nivel);

  Optional<Estudiante> findByCedula(String cedula);
}
