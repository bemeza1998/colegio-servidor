package ec.edu.espe.colegioservidor.repository;

import ec.edu.espe.colegioservidor.model.Paralelo;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParaleloRepository extends MongoRepository<Paralelo, String> {
  List<Paralelo> findByNivelOrderByLetra(Integer nivel);

  Optional<Paralelo> findByNivelAndLetra(Integer nivel, String letra);
}
