package dar.iitu.kz.producerservice.services;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import dar.iitu.kz.producerservice.model.Car;
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
    public class CarInformationService {

        @Autowired
        private RestTemplate restTemplate;

        @HystrixCommand(
                fallbackMethod = "getCarByIdFallback",
                threadPoolKey = "getCarById",
                threadPoolProperties = {
                        @HystrixProperty(name="coreSize", value="20"),
                        @HystrixProperty(name="maxQueueSize", value="50")
                }
        )
        public Car getCarById(String id) {
            String apiCredentials = "info-client:p@ssword";
            String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Basic " + base64Credentials);
            HttpEntity<String> entity = new HttpEntity<>(headers);


            return restTemplate.exchange("http://detailed-info-service/car/info/" + id,
                    HttpMethod.GET, entity, Car.class).getBody();

        }

        public List<Car> getCarByIdFallback() {
            return Arrays.asList(new Car("0", "No brand", "No color", "No number", "No url"));

        }

    }
