package HIS_E2.app_sanidad.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import HIS_E2.app_sanidad.model.Cita;

@Repository
public interface CitaRepository extends MongoRepository<Cita, String> {
	
	@Query(value = "{ 'dniMedico' : ?0}")
	List<Cita> findByDniMedico(String dniMedico);

}
