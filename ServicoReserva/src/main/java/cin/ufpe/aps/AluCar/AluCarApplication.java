package cin.ufpe.aps.AluCar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AluCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(AluCarApplication.class, args);
	}

}
