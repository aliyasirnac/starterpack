package nac.spring.starterpack.core.dataAccess;

import nac.spring.starterpack.core.entities.User;
import nac.spring.starterpack.core.utilities.results.DataResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    //find by username
    User findByUserName(String username);
}
