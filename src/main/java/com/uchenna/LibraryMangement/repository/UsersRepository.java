package com.uchenna.LibraryMangement.repository;

import com.uchenna.LibraryMangement.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    public Users findByFullName(String name);
    public Users findByEmail(String email);
    public Users findByAddress(String address);
    public Users findByAge(int age);
}
