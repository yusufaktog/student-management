package com.aktog.yusuf.student_management.dto.converter;

import com.aktog.yusuf.student_management.dto.StudentDto;
import com.aktog.yusuf.student_management.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class StudentDtoConverter {
    private final DepartmentDtoConverter converter;

    public StudentDtoConverter(DepartmentDtoConverter converter) {
        this.converter = converter;
    }

    public StudentDto convert(Student from){
        return new StudentDto(
                Objects.requireNonNull(from.getId()),
                from.getName(),
                from.getSurname(),
                from.getStudentNo(),
                from.getBirthday(),
                converter.convert(from.getDepartment()),
                from.getStartYear(),
                from.getEducationType(),
                from.getGender()

        );
    }
    public List<StudentDto> convert (List<Student> from){
        return from.stream().map(this::convert).collect(Collectors.toList());
    }



}