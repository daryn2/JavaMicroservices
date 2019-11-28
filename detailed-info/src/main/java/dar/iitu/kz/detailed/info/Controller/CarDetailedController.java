package dar.iitu.kz.detailed.info.Controller;


import dar.iitu.kz.detailed.info.Model.Car;
import dar.iitu.kz.detailed.info.Repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/car/info")
public class CarDetailedController {
    @Autowired
    CarRepository carRepository;

    @GetMapping
    public List<Car> getCars() {
        List<Car> cars = carRepository.findAll();
        
//        List<Car> cars = Arrays.asList(
//                new Car("1", "Lexus", "Red", "123123", "https://www.lexus.com/cm-img/hybridLP/LEX-UXH-hybrid-page-600x342-LEX-UXH-MY19-0006_M75.jpg"),
//                new Car("2", "Lexus 123", "Black", "123123", "https://m.economictimes.com/thumb/height-450,width-800,imgsize-70641,msid-65753363/lexus1.jpg")
//        );
        return cars;
    }
    @GetMapping("/{id}")
    public Car getBookById(@PathVariable("id") String id) {

        return new Car("1", "Lexus", "Red", "123123", "https://m.economictimes.com/thumb/height-450,width-800,imgsize-70641,msid-65753363/lexus1.jpg");
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }


}
