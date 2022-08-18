package ec.edu.espe.colegioservidor.resource;

import ec.edu.espe.colegioservidor.model.Estudiante;
import ec.edu.espe.colegioservidor.service.EstudianteService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/estudiante")
@RequiredArgsConstructor
public class EstudianteResource {
  private final EstudianteService service;

  @PostMapping
  public ResponseEntity<Estudiante> crearEstudiantes(@RequestBody List<Estudiante> estudiantes) {
    this.service.crearEstudiantes(estudiantes);
    return ResponseEntity.ok().build();
  }

  @GetMapping(path = "/{nivel}")
  public ResponseEntity<List<Estudiante>> estudiantesPorNivel(
      @PathVariable("nivel") Integer nivel) {
    try {
      List<Estudiante> estudiantes = this.service.estudiantesPorNivel(nivel);
      return ResponseEntity.ok(estudiantes);
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @PutMapping(path = "/{cedula}/{nivel}")
  public ResponseEntity<String> asignarEstudiante(
      @PathVariable("cedula") String cedula, @PathVariable("nivel") Integer nivel) {
    try {
      this.service.asignarEstudiante(cedula, nivel);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }
}
