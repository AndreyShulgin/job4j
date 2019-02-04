package ru.job4j.school;

public class Student {
    private int score;
    private String secondName;
    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student(int score) {
        this.score = score;
    }
    public Student(int score, String secondName) {
        this.score = score;
        this.secondName = secondName;
    }
}
