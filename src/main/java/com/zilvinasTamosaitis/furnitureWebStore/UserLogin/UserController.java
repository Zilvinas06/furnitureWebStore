package com.zilvinasTamosaitis.furnitureWebStore.UserLogin;

import com.zilvinasTamosaitis.furnitureWebStore.products.Product;
import com.zilvinasTamosaitis.furnitureWebStore.products.ProductRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/get")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/add")
    public void createUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @DeleteMapping(path = "/{id}")
    public User deleteUser(@PathVariable("id") long id) {
        User user = userRepository.getOne(id);
        userRepository.deleteById(id);
        return user;
    }


    @PutMapping (path = "/updateUser/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") Long userId)
            throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        user.setName(user.getName());
        user.setPassword(user.getPassword());
        user.setType(user.getType());
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);

    }

}
