package com.example.taskv2.domain;

import com.example.taskv2.Service.GroupService;
import org.springframework.beans.factory.annotation.Value;

import java.util.*;



public class Group {

    private String name;

    public Group(String name) {
        this.name = name;
    }


    public static Group addGroup(String name, List<Subject> subjectList){
        if(GroupService.canAddGroup()) {
            Group group = new Group(name);
            GroupService.add(group);
            return group;
        }
        return null;
    }

    public static void getAllGroups(){
        // to do

    }

    public static void deleteGroup(){
        // to do
    }
}
