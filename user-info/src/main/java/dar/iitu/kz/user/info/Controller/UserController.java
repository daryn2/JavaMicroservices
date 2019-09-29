package dar.iitu.kz.user.info.Controller;


import dar.iitu.kz.user.info.Model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping()
    List<User> getUsers() {
        List<User> users = Arrays.asList(
                new User("1", "John", 22),
                new User("2", "Alex", 30)
        );
        return users;
    }
}
