package com.yusuf.aktog.student_management.dto.converter;

import com.yusuf.aktog.student_management.dto.CourseDto;
import com.yusuf.aktog.student_management.entity.Course;
import org.springframework.stereotype.Component;

import java.util.Objects;

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
}