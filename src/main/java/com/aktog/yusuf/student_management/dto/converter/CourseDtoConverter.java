package com.aktog.yusuf.student_management.dto.converter;

import com.aktog.yusuf.student_management.dto.CourseDto;
import com.aktog.yusuf.student_management.entity.Course;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CourseDtoConverter {
    public CourseDto convert(Course from) {
        return new CourseDto(
                Objects.requireNonNull(from.getId()),
                from.getName(),
                from.getSemester(),
                from.getYear(),
                Objects.requireNonNull(from.getInstructor().getId()),
                from.getEnrollmentLimit(),
                from.getCredits()
        );
    }

    public List<CourseDto> convert(List<Course> from){
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}