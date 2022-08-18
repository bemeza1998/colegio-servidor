package ec.edu.espe.colegioservidor.config.mongo;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ApplicationValues {
  private final String mongoHost;
  private final String mongoDB;
  private final String mongoUsr;
  private final String mongoPwd;
  private final String mongoAut;

  public ApplicationValues(
      @Value("${ec.edu.espe.colegioservidor.mongo.host}") String mongoHost,
      @Value("${ec.edu.espe.colegioservidor.mongo.db}") String mongoDB,
      @Value("${ec.edu.espe.colegioservidor.mongo.usr}") String mongoUsr,
      @Value("${ec.edu.espe.colegioservidor.mongo.pwd}") String mongoPwd,
      @Value("${ec.edu.espe.colegioservidor.mongo.aut}") String mongoAut) {

    this.mongoHost = mongoHost;
    this.mongoDB = mongoDB;
    this.mongoUsr = mongoUsr;
    this.mongoPwd = mongoPwd;
    this.mongoAut = mongoAut;
  }
}
