package com.example.taskv2.domain;

import com.example.taskv2.Service.PersonService;

import java.util.Date;
import java.util.Random;
import java.util.stream.Collectors;

public class Person {


    private String firstName;
    private String lastName;
    private Date birthDate;
    private String email;
    private String token;

    public Person(String email) {
        this.email = email;
    }

    public Person(String firstName, String lastName, Date birthDate, String email, String token) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.token = token;
    }

    public static Person addPerson(String firstName, String lastName, Date birthDate, String email){
        if(PersonService.canAddPerson(email)) {
            String password = new Random().ints(10, 33, 122).mapToObj(i -> String.valueOf((char) i)).collect(Collectors.joining());
            Person person = new Person(firstName, lastName, birthDate, email,password);
            PersonService.addPerson(person);
            // generatePassword
            return person;
        }
        return null;
    }



    public String getToken() {
        return token;
    }

    public String getEmail() {
        return email;
    }


}
