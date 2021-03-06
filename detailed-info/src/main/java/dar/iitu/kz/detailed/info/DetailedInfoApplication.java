package dar.iitu.kz.detailed.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DetailedInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DetailedInfoApplication.class, args);
	}

}
