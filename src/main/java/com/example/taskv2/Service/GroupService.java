package com.example.taskv2.Service;

import com.example.taskv2.domain.Group;
import com.example.taskv2.domain.Vote;
import com.sun.mail.imap.protocol.BODY;
import org.springframework.beans.factory.annotation.Value;

import java.util.*;

public class GroupService {


    public static List<Group> groupList = new ArrayList<>();

    @Value("${max_group_number}")
    private int maxGroupNumber;

    public static void add(Group group){
        groupList.add(group);
    }

    public static int getSize(){
        if(groupList==null){
            return 0;
        }
        return groupList.size();
    }

    public static Boolean canAddGroup(){
        if(getSize()<5){
            return true;
        }
        return false;
    }

    public static Boolean isSizeCorrect(){
        if(getSize()<=5){
            return true;
        }
        return false;
    }

    public static List<Group> getAllGroups(){
        return groupList;
    }
}
