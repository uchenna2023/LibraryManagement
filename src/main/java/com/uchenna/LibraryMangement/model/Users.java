package com.uchenna.LibraryMangement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "field can not be empty")
    @Size(min = 6, max = 15)
    private String fullName;
    @Min(value = 8, message = "minimum age is 8 years old")
    @Max(value = 70, message = "maximum year is 70 years old")
    @NotEmpty(message = "age must not be empty")
    private  int age;
    @Column(unique = true)
    @Email(message = "Enter a valid email address")
    private String email;
    @NotNull(message = "Please enter an address")
    private String address;

    //@OneToOne(mappedBy = "users")
    //private BorrowedBooks userBorrowed;

    public Users(){

    }


    public Users(String fullName, int age, String email, String address) {
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
