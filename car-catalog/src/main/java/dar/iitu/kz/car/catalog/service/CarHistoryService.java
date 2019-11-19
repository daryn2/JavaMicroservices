package dar.iitu.kz.car.catalog.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import dar.iitu.kz.car.catalog.model.Car;
import dar.iitu.kz.car.catalog.model.Rating;
import dar.iitu.kz.car.catalog.model.User;
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
public class CarHistoryService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(
            fallbackMethod = "getCarHistoryFallback",
            threadPoolKey = "getCarCatalogrBooks",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50")
            }
    )
    public List<Rating> getCarRating(String id) {
        String apiCredentials = "history-client:p@ssword";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<Rating>> ratingsRequest = restTemplate.exchange(
                "http://localhost:8083/history/rating/" + id,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Rating>>(){});
        return ratingsRequest.getBody();

    }

    public List<Rating> getCarHistoryFallback(String userId) {
        return Arrays.asList(new Rating("0", 0, "No review", new User("0", "no name", 0)));

    }
}
