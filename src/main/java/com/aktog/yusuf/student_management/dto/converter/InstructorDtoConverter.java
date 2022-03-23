package com.aktog.yusuf.student_management.dto.converter;

import com.aktog.yusuf.student_management.dto.InstructorDto;
import com.aktog.yusuf.student_management.entity.Instructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class InstructorDtoConverter {
    private final CourseDtoConverter converter;
    private final FacultyDtoConverter facultyDtoConverter;


    public InstructorDtoConverter(CourseDtoConverter converter, FacultyDtoConverter facultyDtoConverter) {
        this.converter = converter;
        this.facultyDtoConverter = facultyDtoConverter;
    }

    public InstructorDto convert(Instructor from) {
        return new InstructorDto(
                Objects.requireNonNull(from.getId()),
                from.getName(),
                from.getSurname(),
                from.getGender(),
                facultyDtoConverter.convert(from.getFaculty()),
                from.getBirthday(),
                Objects.requireNonNull(from.getCoursesTaught()).stream().map(converter::convert).collect(Collectors.toSet())
        );
    }

    public List<InstructorDto> convert (List<Instructor> from){
        return from.stream().map(this::convert).collect(Collectors.toList());
    }


}