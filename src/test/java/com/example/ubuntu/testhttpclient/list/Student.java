package com.example.ubuntu.testhttpclient.list;

/**
 * Created by monotonewang on 2018/3/19.
 */

public class Student {
    public String name;
    public int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }



    public Student(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return id == student.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

}
