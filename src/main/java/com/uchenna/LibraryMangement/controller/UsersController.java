package com.uchenna.LibraryMangement.controller;

import com.uchenna.LibraryMangement.globalExceptionHandler.UserNotFoundException;
import com.uchenna.LibraryMangement.model.Users;
import com.uchenna.LibraryMangement.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsersController {

    public UsersService usersService;

    public  UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    @PostMapping("/user")
    public ResponseEntity<String> addUsers(@RequestBody @Valid Users users){
        return new ResponseEntity<>(usersService.addUser(users ), HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id){
        usersService.deleteUser(id);
    }


    @PutMapping("/user/{id}")
    public Users updateUser(@PathVariable Long id, @RequestBody @Valid Users users) throws UserNotFoundException {
        return usersService.updateUser(id,users);

    }
}
