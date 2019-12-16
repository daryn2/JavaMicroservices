package dar.iitu.kz.authservice.repository;

import dar.iitu.kz.authservice.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser,String> {

}
