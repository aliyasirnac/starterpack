package nac.spring.starterpack.api.controllers;


import nac.spring.starterpack.business.abstracts.UserService;
import nac.spring.starterpack.core.entities.User;
import nac.spring.starterpack.core.utilities.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/users")
@RestController

public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public DataResult<List<User>> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    public DataResult<User> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/update")
    public DataResult<User> updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public DataResult<User> deleteUser(@RequestParam long id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/get/{id}")
    public DataResult<User> getUserById(@RequestParam long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/getByUsername/{username}")
    public DataResult<User> getUserByUsername(@RequestParam String username) {
        return userService.getUserByUsername(username);
    }
}
