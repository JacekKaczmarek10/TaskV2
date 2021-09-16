package com.example.taskv2.domain;

import com.example.taskv2.Service.TokenService;
import com.example.taskv2.Service.VoteService;
import com.example.taskv2.dto.GroupsResult;

import java.util.ArrayList;
import java.util.List;

public class Vote {

    private Person person;
    private Group group;

    public Vote(Person person, Group group) {
        this.person = person;
        this.group = group;
    }

    public static Vote voteForGroup(Person person, Group group, String token){
        if(!VoteService.checkIfPersonVoted(person) && TokenService.isTokenCorrect(person.getToken(),token)) {
            Vote vote = new Vote(person, group);
            VoteService.addVote(vote);
            return vote;
        }
        return null;
    }

    public static void showResults(){
        List<GroupsResult> list = new ArrayList<>();
    }

    public static void deleteVote(Person person){
        // to do
    }

    public Person getPerson() {
        return person;
    }
}
