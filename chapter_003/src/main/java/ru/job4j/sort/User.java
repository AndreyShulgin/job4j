package ru.job4j.sort;

public class User implements Comparable<User> {
    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.age);
    }

    private String name;
    private Integer age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}