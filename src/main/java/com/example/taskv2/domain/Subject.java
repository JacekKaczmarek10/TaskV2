package com.example.taskv2.domain;


import com.example.taskv2.dto.GroupsResult;
import java.util.*;

import java.util.ArrayList;
import java.util.Date;

public class Subject {

    private String name;
    private List<Date> list;
    private Group group;

    public Subject(String name,Group group) {
        this.name = name;
    }

    public Subject(String name, List<Date> list,Group group) {
        this.name = name;
        this.list = list;
    }

    public static void addSubject(Group group,List<Date> dateList, String name){
        Subject subject = new Subject(name,dateList,group);
    }

    public static void deleteSubject(Group group, String name){
        // to do
    }

    public static void getAllSubjects(Group group){
        // to do
    }

}
