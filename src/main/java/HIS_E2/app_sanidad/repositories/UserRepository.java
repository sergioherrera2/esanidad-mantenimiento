package HIS_E2.app_sanidad.repositories;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.client.MongoCollection;

import HIS_E2.app_sanidad.model.Usuario;

@Repository
public interface UserRepository extends MongoRepository <Usuario, String>{
	
	@Query( value = "{'dni' : ?0}")
	Usuario findByDni(String string);
	
	/*Document doc = MongoCollection
		    .find(eq("_id", new Binary((byte) 0, Base64.getDecoder().decode("nCgNlWhzJM9/lHDVQmXQrg=="))))
		    .first();*/
}