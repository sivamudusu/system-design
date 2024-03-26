package org.example.designpatterns.protoypeAndRegistry;

public class Student implements prototype{
    private int id;
    private String name;
    private String email;
    private String batch;
    private String timings;
    private String instructor;
    private String batchName;


    public Student( String batch, String timings, String instructor, String batchName) {
        this.batch = batch;
        this.timings = timings;
        this.instructor = instructor;
        this.batchName = batchName;
    }

    public Student(Student student) {
        this.batch = student.batch;
        this.batchName = student.batchName;
        this.timings = student.timings;
        this.instructor = student.instructor;
    }

    @Override
    public Student clone() {
        return new Student(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }
}
