package dar.iitu.kz.car.catalog.service;

import dar.iitu.kz.car.catalog.model.Car;
import dar.iitu.kz.car.catalog.model.CarCatalog;
import dar.iitu.kz.car.catalog.model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CarInfoService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(
            fallbackMethod = "getCarCatalogFallback",
            threadPoolKey = "getCarCatalog",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="20"),
                    @HystrixProperty(name="maxQueueSize", value="50")
            }
    )
    public List<Car> getCarCatalog() {
        String apiCredentials = "info-client:p@ssword";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<Car>> response = restTemplate.exchange(
                "http://localhost:8082/car/info",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Car>>(){});
        return response.getBody();

    }

    public List<Car> getCarCatalogFallback() {
        return Arrays.asList(new Car("0", "No brand", "No color", "No number", "No url"));

    }

}
