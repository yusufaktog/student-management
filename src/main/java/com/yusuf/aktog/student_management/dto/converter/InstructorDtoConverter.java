package com.yusuf.aktog.student_management.dto.converter;

import com.yusuf.aktog.student_management.dto.InstructorDto;
import com.yusuf.aktog.student_management.entity.Instructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class InstructorDtoConverter {
    private final CourseDtoConverter converter;

    public InstructorDtoConverter(CourseDtoConverter converter) {
        this.converter = converter;
    }

    public InstructorDto convert(Instructor from){
        return new InstructorDto(
                Objects.requireNonNull(from.getId()),
                from.getName(),
                from.getSurname(),
                from.getBirthday(),
                Objects.requireNonNull(from.getLessonsTaught()).stream().map(converter::convert).collect(Collectors.toSet())
        );
    }


}