package com.example.taskv2.Service;

import com.example.taskv2.domain.Person;
import com.example.taskv2.domain.Vote;

import java.util.ArrayList;
import java.util.List;

public class VoteService {

    public static List<Vote> voteList = new ArrayList<>();

    public static void addVote(Vote vote){
        voteList.add(vote);
    }



    public static Boolean checkIfPersonVoted(Person person){
        for(Vote vote : voteList){
            Person person1 = vote.getPerson();
            if(person1.getEmail().equals(person.getEmail())){
                return true;
            }
        }
        return false;
    }

    public static int  getVotesNumber(){
        return voteList.size();
    }

    public static List<Vote>  getVotes(){
        return voteList;
    }



}
