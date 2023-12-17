package cin.ufpe.aps.AluCar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cin.ufpe.aps.AluCar.dados.abstractFactory.FabricaConcretaSql;

@SpringBootApplication
public class AluCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(AluCarApplication.class, args);
	}

}
