package br.com.breno.microservices_study.controllers;

import br.com.breno.microservices_study.models.UserModel;
import br.com.breno.microservices_study.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService personService;

    public UserController(UserService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<UserModel> saveUser(@RequestBody UserModel user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.saveUser(user));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserModel> getUser(@PathVariable UUID userId) {
        return ResponseEntity.status(HttpStatus.OK).body(personService.getUser(userId));
    }
}
