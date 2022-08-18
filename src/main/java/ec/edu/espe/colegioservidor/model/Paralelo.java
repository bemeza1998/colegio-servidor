package ec.edu.espe.colegioservidor.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Data
@Builder
@Document(collection = "paralelos")
@TypeAlias("paralelos")
public class Paralelo {
  @Id private String id;

  private Integer nivel;

  private String letra;

  @DocumentReference private List<Estudiante> estudiantes;
}
