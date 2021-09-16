package com.example.taskV2;

import com.example.taskv2.Service.GroupService;
import com.example.taskv2.Service.PersonService;
import com.example.taskv2.Service.VoteService;
import com.example.taskv2.domain.Group;
import com.example.taskv2.domain.Person;
import com.example.taskv2.domain.Vote;
import junit.framework.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.util.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TaskV2ApplicationTests {



    @Test
    void testAddGroupMethod(){
        Group group = null;
        Assert.assertTrue(GroupService.isSizeCorrect());


        // check if can add more than 5 groups
        group = Group.addGroup("kot",null);
        group = Group.addGroup("kot",null);
        group = Group.addGroup("kot",null);
        group = Group.addGroup("kot",null);
        group = Group.addGroup("kot",null);
        group = Group.addGroup("kot",null);
        group = Group.addGroup("kot",null);
        Assert.assertTrue(GroupService.isSizeCorrect());
        group = Group.addGroup("kot",null);
        group = Group.addGroup("kot",null);
        Assert.assertTrue(GroupService.isSizeCorrect());

    }

    @Test
    void testCreateUserMethod(){
        Assert.assertEquals(PersonService.checkPersonList(),0);
        Person jacek = Person.addPerson("Jacek","Kaczmarek",new Date(),"email@email.com");
        Person pawel = Person.addPerson("Jacek","Kaczmarek",new Date(),"email@email.com");
        Person pawel1 = Person.addPerson("Jacek","Kaczmarek",new Date(),"email@email.com");
        Person pawel2 = Person.addPerson("Jacek","Kaczmarek",new Date(),"email@email.com");
        Assert.assertEquals(PersonService.checkPersonList(),1);
        Person pawel3 = Person.addPerson("Jacek","Kaczmarek",new Date(),"emailX@email.com");
        Person pawel4 = Person.addPerson("Jacek","Kaczmarek",new Date(),"emailX1@email.com");
        Assert.assertEquals(PersonService.checkPersonList(),3);
    }

    @Test
    void testVoteMethod(){
        Group group1 = Group.addGroup("kot",null);
        Group group2 = Group.addGroup("pies",null);

        PersonService.deletePerson(new Person("email@email.com"));
        PersonService.deletePerson(new Person("gmail@email.com"));

        Person jacek = Person.addPerson("Jacek","Kaczmarek",new Date(),"email@email.com");
        Person pawel = Person.addPerson("Pawel","Kaczmarek",new Date(),"gmail@email.com");

        // test check token method and can vote method
        Assert.assertEquals(0,VoteService.getVotesNumber());
        Vote vote1 = Vote.voteForGroup(jacek,group1,"ALAMAKOTA");
        Vote vote2 = Vote.voteForGroup(jacek,group1,jacek.getToken());
        Assert.assertEquals(1,VoteService.getVotesNumber());

        Vote vote3 = Vote.voteForGroup(jacek,group2,jacek.getToken());
        Vote vote4 = Vote.voteForGroup(jacek,group1,jacek.getToken());
        Vote vote5 = Vote.voteForGroup(pawel,group1,pawel.getToken());
        Assert.assertEquals(2,VoteService.getVotesNumber());
    }



}
