package com.yusuf.aktog.student_management.dto.converter;

import com.yusuf.aktog.student_management.dto.DepartmentDto;
import com.yusuf.aktog.student_management.dto.StudentDto;
import com.yusuf.aktog.student_management.entity.Department;
import com.yusuf.aktog.student_management.entity.Student;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StudentDtoConverter {
    private final DepartmentDtoConverter converter;

    public StudentDtoConverter(DepartmentDtoConverter converter) {
        this.converter = converter;
    }

    public StudentDto convert(Student from){
        return new StudentDto(
                Objects.requireNonNull(from.getId()),
                from.getStudentNo(),
                from.getName(),
                from.getSurname(),
                from.getBirthday(),
                converter.convert(from.getDepartment()),
                from.getStartYear()

        );
    }



}