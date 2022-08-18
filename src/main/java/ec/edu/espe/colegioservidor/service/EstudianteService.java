package ec.edu.espe.colegioservidor.service;

import ec.edu.espe.colegioservidor.exception.EstudianteException;
import ec.edu.espe.colegioservidor.model.Estudiante;
import ec.edu.espe.colegioservidor.model.Paralelo;
import ec.edu.espe.colegioservidor.repository.EstudianteRepository;
import ec.edu.espe.colegioservidor.repository.ParaleloRepository;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstudianteService {
  private final EstudianteRepository estudianteRepository;
  private final ParaleloRepository paraleloRepository;

  public void crearEstudiantes(List<Estudiante> estudiantes) {
    for (Estudiante estudiante : estudiantes) {
      this.crear(estudiante);
    }
  }

  // Implementar un servicio de negocio que dado un nivel, devuelva toda la lista de estudiantes
  // perteneciente a ese nivel.
  public List<Estudiante> estudiantesPorNivel(Integer nivel) {
    return this.estudianteRepository.findByNivelOrderByCedula(nivel);
  }

  // 3. Implementar un servicio que asigne un estudiante a un paralelo. El servicio debe esperar la
  // siguiente información:
  // a. Cedula
  // b. Nivel
  // - La asignación de paralelo la realizará de forma randómica.
  // - Cada nivel tiene tres paralelos
  // - Se debe verificar que la distribución de estudiantes por paralelo sea equilibrada

  public void asignarEstudiante(String cedula, Integer nivel) {
    Estudiante estudiante = this.buscar(cedula);
    List<Paralelo> paralelosNivel = this.paraleloRepository.findByNivelOrderByLetra(nivel);
    Integer paraleloNumero = randInt(0, 2);
    Paralelo paralelo = paralelosNivel.get(paraleloNumero);
    paralelo.getEstudiantes().add(estudiante);
    this.paraleloRepository.save(paralelo);
  }

  private static int randInt(int min, int max) {
    Random rand = new Random();
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
  }

  public void crear(Estudiante estudiante) throws EstudianteException {
    if (this.buscar(estudiante.getCedula()) != null) {
      throw new EstudianteException(
          "El estudiante con cedula " + estudiante.getCedula() + " ya existe");
    }
    if (estudiante.getNivel() < 1 || estudiante.getNivel() > 10) {
      throw new EstudianteException("El nivel debe encontrarse entre 1 a 10");
    }
    this.estudianteRepository.save(estudiante);
  }

  private Estudiante buscar(String cedula) {
    Optional<Estudiante> estudiante = this.estudianteRepository.findByCedula(cedula);
    if (estudiante.isPresent()) {
      return estudiante.get();
    } else {
      return null;
    }
  }
}
