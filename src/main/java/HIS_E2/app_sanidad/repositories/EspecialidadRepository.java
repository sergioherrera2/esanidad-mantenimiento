package HIS_E2.app_sanidad.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import HIS_E2.app_sanidad.model.Especialidad;

@Repository
public interface EspecialidadRepository extends MongoRepository<Especialidad, String> {

	@Query(value = "{ 'nombreEspecialidad' : ?0}")
	List<Especialidad> findCustomEspecialidad(String nombreEspecialidad);
}
