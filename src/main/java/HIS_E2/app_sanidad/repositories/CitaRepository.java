package HIS_E2.app_sanidad.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import HIS_E2.app_sanidad.model.Cita;

@Repository
public interface CitaRepository extends MongoRepository<Cita, String> {

}
