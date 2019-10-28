package HIS_E2.app_sanidad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**Clase Lanzadora del SpringBoot.
 * @author Miguel
 *
 */
@SpringBootApplication
@EnableMongoRepositories
public class BootApplication {

	/**Main de la clase lanzadora de SpringBoot.
	 * @param args del main.
	 */
	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}
}
