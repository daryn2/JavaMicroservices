package dar.iitu.kz.rent.history.controller;


import dar.iitu.kz.rent.history.model.Rating;
import dar.iitu.kz.rent.history.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {
    @GetMapping("/{carId}")
    public List<User> getLastByCarId(@PathVariable("carId") String carId) {
        List<User> users = Arrays.asList(
                new User("1", "John", 22),
                new User("2", "Alex", 30)
        );
        return users;
    }
    @GetMapping("/rating/{carId}")
    public List<Rating> getRating(@PathVariable("carId") String carId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("1", 10, "the best car", new User("2", "Alex", 30)),
                new Rating("2", 5, "problems with engine", new User("1", "John", 22))
        );
        return ratings;
    }
}
