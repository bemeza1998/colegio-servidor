package ec.edu.espe.colegioservidor.resource;

import ec.edu.espe.colegioservidor.model.Estudiante;
import ec.edu.espe.colegioservidor.service.ParaleloService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/paralelo")
@RequiredArgsConstructor
public class ParaleloResource {
  private final ParaleloService service;

  @GetMapping(path = "/{nivel}/{letra}")
  public ResponseEntity<List<Estudiante>> estudiantesPorNivel(
      @PathVariable("nivel") Integer nivel, @PathVariable("letra") String letra) {
    try {
      List<Estudiante> estudiantes = this.service.estudiantesParaleloNivel(nivel, letra);
      return ResponseEntity.ok(estudiantes);
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }
}
