package AI.Job.Application.Platform.controller;

import AI.Job.Application.Platform.dto.UserRequest;
import AI.Job.Application.Platform.entity.User;
import AI.Job.Application.Platform.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import AI.Job.Application.Platform.dto.LoginRequest;
import AI.Job.Application.Platform.dto.LoginResponse;
import jakarta.validation.Valid;


import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User register(@Valid @RequestBody UserRequest request) {

        return userService.register(request);
    }

    @GetMapping
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {

        return userService.getUserById(id);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @Valid @RequestBody LoginRequest request) {

        return ResponseEntity.ok(
                userService.login(request)
        );
    }

}
