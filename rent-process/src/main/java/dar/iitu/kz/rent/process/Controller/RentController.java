package dar.iitu.kz.rent.process.Controller;


import dar.iitu.kz.rent.process.Model.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping
public class RentController {
    @GetMapping
    public List<Car> getFreeCars() {
        List<Car> cars = Arrays.asList(
                new Car("1", "Lexus", "Red", "123123"),
                new Car("2", "Lexus 123", "Black", "123123")
        );
        return cars;
    }

}
