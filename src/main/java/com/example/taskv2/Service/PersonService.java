package com.example.taskv2.Service;

import com.example.taskv2.domain.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonService {

    public static List<Person> personList = new ArrayList<>();

    public static void addPerson(Person person){
        personList.add(person);
    }


    public static int checkPersonList(){
        return personList.size();
    }

    public static boolean containsName(final List<Person> list, final String name){
        return list.stream().map(Person::getEmail).filter(name::equals).findFirst().isPresent();
    }

    public static Boolean canAddPerson(String email){
        if(containsName(personList,email)){
            return false;
        }
        return true;
    }

    public static void deletePerson(Person person){
        Iterator<Person> iter = personList.iterator();

        while ((iter.hasNext())){
            if(iter.next().getEmail().equals(person.getEmail())){
                iter.remove();
            }
        }

    }

    public static List<Person> getPersonList(){
        return personList;
    }


}
