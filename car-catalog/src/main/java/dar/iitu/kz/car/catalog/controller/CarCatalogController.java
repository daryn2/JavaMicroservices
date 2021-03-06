package dar.iitu.kz.car.catalog.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import dar.iitu.kz.car.catalog.model.Car;
import dar.iitu.kz.car.catalog.model.CarCatalog;
import dar.iitu.kz.car.catalog.model.Rating;
import dar.iitu.kz.car.catalog.service.CarHistoryService;
import dar.iitu.kz.car.catalog.service.CarInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/carcatalog")
public class CarCatalogController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CarInfoService carInfoService;
    @Autowired
    private CarHistoryService carHistoryService;


    @GetMapping()

    public List<CarCatalog> getAllCars(){
        List<CarCatalog> carCatalogs = new ArrayList<>();


        List<Car> cars = carInfoService.getCarCatalog();


        for (Car car: cars) {

            List<Rating> history = carHistoryService.getCarRating(car.getId());

            // getAverageRatingByCarId
            List<Integer> ratings = history.stream().map(Rating::getRating).sequential().collect(Collectors.toList());
            List<String> reviews = history.stream().map(Rating::getReview).sequential().collect(Collectors.toList());

            carCatalogs.add(new CarCatalog(car.getId(),car.getBrand(), car.getColour(), car.getNumber(), car.getUrl(), ratings, reviews));

        }

        return carCatalogs;
    }




    @GetMapping("/{id}")
    public Car getCar() {

        Car carBook = restTemplate.getForObject("http://localhost:8082/car/info/1", Car.class);

        return carBook;
    }



    @PostMapping()
    public Car createCar() {
        return new Car("1", "Ferrari", "Red", "123123", "https://m.economictimes.com/thumb/height-450,width-800,imgsize-70641,msid-65753363/lexus1.jpg");
    }

}
