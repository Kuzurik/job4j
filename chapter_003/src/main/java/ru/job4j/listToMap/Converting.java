package ru.job4j.listToMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Converting {
    public Map<String,Student> convert(List<Student> students) {
        return students.stream().distinct().collect(Collectors.toMap(Student::getFamily,student -> student));
    }
}
