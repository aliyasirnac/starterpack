package nac.spring.starterpack.business.abstracts;

import nac.spring.starterpack.core.entities.User;
import nac.spring.starterpack.core.utilities.results.DataResult;

import java.util.List;

public interface UserService {
    DataResult<List<User>> getAllUsers();
    DataResult<User> addUser(User user);
    DataResult<User> updateUser( User user);
    DataResult<User> deleteUser(long id);
    DataResult<User> getUserById(long id);
    DataResult<User> getUserByUsername(String username);
}
