package ru.job4j.school;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {

    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    public Map<String, Student> toMap(List<Student> students) {
        return students.stream().collect(Collectors.toMap(
                Student :: getSecondName,
                e -> e)
        );
    }

    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .sorted(Comparator.comparing(Student ::getScore).reversed())
                .flatMap(Stream :: ofNullable)
                .takeWhile(student -> student.getScore() > bound)
                .collect(Collectors.toList());
    }
}
