package ru.job4j.school;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class SchoolTest {

    @Test
    public void when9Assigned10A() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        students.add(new Student(40));
        students.add(new Student(60));
        students.add(new Student(80));
        List<Student> result = school.collect(students, student -> student.getScore() > 70);
        assertThat(result.get(0).getScore(), is(80));
    }

    @Test
    public void when9Assigned10B() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        students.add(new Student(40));
        students.add(new Student(60));
        students.add(new Student(80));
        List<Student> result = school.collect(students, student -> student.getScore() > 50 && student.getScore() <= 70);
        assertThat(result.get(0).getScore(), is(60));
    }

    @Test
    public void when9Assigned10C() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        students.add(new Student(40));
        students.add(new Student(60));
        students.add(new Student(80));
        List<Student> result = school.collect(students, student -> student.getScore() <= 50);
        assertThat(result.get(0).getScore(), is(40));
    }

    @Test
    public void whenListToMap() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        students.add(new Student(10, "Max"));
        Map<String, Student> result = school.toMap(students);
        assertThat(result.keySet().contains("Max"), is(true));

    }

    @Test
    public void whenStudentScopeUpperBound() {
        School school = new School();
        List<Student> students = List.of(new Student(70, "Andrey"),
                new Student(80, "Alex"));
        List<Student> rst = school.levelOf(students, 75);
        assertThat(rst.get(0).getSecondName(), is("Alex"));
    }
}
