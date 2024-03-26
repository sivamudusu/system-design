package org.example.designpatterns.protoypeAndRegistry;

import java.util.HashMap;

public class StudentRegistry {
    private HashMap<String,Student> studentRegistry;

    public StudentRegistry(){
        this.studentRegistry = new HashMap<>();

    }

    public void add(Student studentProtoype){
        studentRegistry.put(studentProtoype.getBatchName(),studentProtoype);
    }
    public Student get(String prototypeName){
        return studentRegistry.get(prototypeName);
    }
}
