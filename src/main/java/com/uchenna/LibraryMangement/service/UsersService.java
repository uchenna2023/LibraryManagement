package com.uchenna.LibraryMangement.service;

import com.uchenna.LibraryMangement.globalExceptionHandler.BookNotFoundException;
import com.uchenna.LibraryMangement.globalExceptionHandler.UserNotFoundException;
import com.uchenna.LibraryMangement.model.Books;
import com.uchenna.LibraryMangement.model.Users;
import com.uchenna.LibraryMangement.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersService {

    public UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public List<Users> getAllUsers(){
        List<Users> allUsers = usersRepository.findAll();
        return allUsers;
    }

    public  String addUser(Users users){
        usersRepository.save(users);
        return "User Created";
    }

    public void deleteUser( Long id){
        usersRepository.deleteById(id);
    }

    public Users updateUser(Long id, Users users) throws UserNotFoundException {

        Users updatedUser = usersRepository.findById(id).orElseThrow(()->new UserNotFoundException("User not found"));

        assert updatedUser != null;
        updatedUser.setAddress(users.getAddress());
        updatedUser.setEmail(users.getEmail());
        updatedUser.setFullName(users.getFullName());
        return usersRepository.save(updatedUser);

    }

    public Users getUserById(Long id) throws UserNotFoundException {
        return usersRepository.findById(id).orElseThrow(() -> new UserNotFoundException(" not found"));
    }
}
