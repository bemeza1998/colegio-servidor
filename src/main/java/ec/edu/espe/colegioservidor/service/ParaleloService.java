package ec.edu.espe.colegioservidor.service;

import ec.edu.espe.colegioservidor.model.Estudiante;
import ec.edu.espe.colegioservidor.model.Paralelo;
import ec.edu.espe.colegioservidor.repository.ParaleloRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParaleloService {
  private final ParaleloRepository paraleloRepository;

  public List<Estudiante> estudiantesParaleloNivel(Integer nivel, String letra) {
    Paralelo paralelo = this.buscarPorNivelYParalelo(nivel, letra);
    return paralelo.getEstudiantes();
  }

  private Paralelo buscarPorNivelYParalelo(Integer nivel, String letra) {
    Optional<Paralelo> paralelo = this.paraleloRepository.findByNivelAndLetra(nivel, letra);
    if (paralelo.isPresent()) {
      return paralelo.get();
    } else {
      return null;
    }
  }
}
