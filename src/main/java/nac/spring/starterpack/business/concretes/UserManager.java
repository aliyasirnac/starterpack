package nac.spring.starterpack.business.concretes;

import nac.spring.starterpack.business.abstracts.UserService;
import nac.spring.starterpack.core.dataAccess.UserDao;
import nac.spring.starterpack.core.entities.User;
import nac.spring.starterpack.core.utilities.results.DataResult;
import nac.spring.starterpack.core.utilities.results.ErrorDataResult;
import nac.spring.starterpack.core.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<User>> getAllUsers() {
        return new SuccessDataResult<>(userDao.findAll(),"Data retrieved successfully");
    }

    @Override
    public DataResult<User> addUser(User user) {
        return new SuccessDataResult<>(userDao.save(user),"User added successfully");
    }

    @Override
    public DataResult<User> updateUser(User user) {
        User userToUpdate = userDao.findById(user.getId()).orElse(null);
        if(userToUpdate != null){
            userToUpdate.setFirstName(user.getFirstName());
            userToUpdate.setLastName(user.getLastName());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPassword(user.getPassword());
            userDao.save(userToUpdate);
            return new SuccessDataResult<>(userToUpdate,"User updated successfully");
        }
        return new ErrorDataResult<>("User not found");
    }

    @Override
    public DataResult<User> deleteUser(long id) {
        User userToDelete = userDao.findById(id).orElse(null);
        if(userToDelete != null){
            userDao.delete(userToDelete);
            return new SuccessDataResult<>(userToDelete,"User deleted successfully");
        }
        return new ErrorDataResult<>("User not found");
    }

    @Override
    public DataResult<User> getUserById(long id) {
        User user = userDao.findById(id).orElse(null);
        if(user != null){
            return new SuccessDataResult<>(user,"User retrieved successfully");
        }
        return new ErrorDataResult<>("User not found");
    }

    @Override
    public DataResult<User> getUserByUsername(String username) {
        User user = userDao.findByUserName(username);
        if(user != null){
            return new SuccessDataResult<>(user,"User retrieved successfully");
        }
        return new ErrorDataResult<>("User not found");
    }
}
