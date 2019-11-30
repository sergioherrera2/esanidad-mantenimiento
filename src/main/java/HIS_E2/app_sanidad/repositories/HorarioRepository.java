package HIS_E2.app_sanidad.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import HIS_E2.app_sanidad.model.Horario;

@Repository
public interface HorarioRepository extends MongoRepository<Horario, String> {

  @Query(value = "{ 'dni' : ?0}")
  Horario findCustomHorario(String dni);
}
