package dar.iitu.kz.authservice.controller;


import dar.iitu.kz.authservice.model.AppUser;
import dar.iitu.kz.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reg")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @PostMapping
    public AppUser createUser(@RequestBody AppUser appUser) {
        AppUser user = appUser;
        user.setPassword(encoder.encode(appUser.getPassword()));
        user.setRole("USER");
        return userRepository.save(user);
    }
    @GetMapping
    public List<AppUser> getUsers() {
        List<AppUser> users = userRepository.findAll();
        return users;
    }
}
