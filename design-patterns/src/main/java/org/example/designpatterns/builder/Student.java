package org.example.designpatterns.builder;

public class Student {
    private int id;
    private String name;
    private int age;
    private int birthyear;
    private String college;
    private int  passedout;

    private Student(int id, String name, int age, int birthyear, String college, int passedout) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthyear = birthyear;
        this.college = college;
        this.passedout = passedout;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthyear=" + birthyear +
                ", college='" + college + '\'' +
                ", passedout=" + passedout +
                '}';
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private int id;
        private String name;
        private int age;
        private int birthyear;
        private String college;
        private int  passedout;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setBirthyear(int birthyear) {
            this.birthyear = birthyear;
            return this;
        }

        public Builder setCollege(String college) {
            this.college = college;
            return this;
        }

        public Builder setPassedout(int passedout) {
            this.passedout = passedout;
            return this;
        }

        private void validate(){
            if(this.age<18){
                throw new GradYearInvalidException();
            }
            if(this.name==null){
                throw new InvalidNameException();
            }
            if (this.passedout > 2023){
                throw new GradYearInvalidException();
            }
        }
        public Student build(){
            validate();
            return new Student(this.id,this.name,this.age,this.birthyear,this.college,this.passedout);
        }


    }
}
