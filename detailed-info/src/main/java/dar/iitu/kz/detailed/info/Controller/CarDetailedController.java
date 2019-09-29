package dar.iitu.kz.detailed.info.Controller;


import dar.iitu.kz.detailed.info.Model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/car/info")
public class CarDetailedController {

    @GetMapping
    public List<Car> getCars() {
        List<Car> cars = Arrays.asList(
                new Car("1", "Lexus", "Red", "123123"),
                new Car("2", "Lexus 123", "Black", "123123")
        );
        return cars;
    }
    @GetMapping("/{id}")
    public Car getBookById(@PathVariable("id") String id) {

        return new Car("1", "Lexus", "Red", "123123");
    }

}
