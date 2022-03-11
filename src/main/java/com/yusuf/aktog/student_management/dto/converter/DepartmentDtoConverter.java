package com.yusuf.aktog.student_management.dto.converter;

import com.yusuf.aktog.student_management.dto.DepartmentDto;
import com.yusuf.aktog.student_management.entity.Department;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Component
public class DepartmentDtoConverter {

    public DepartmentDto convert(Department from) {
        return new DepartmentDto(
                from.getName(),
                from.getDepartmentCode(),
                from.getEnrollmentLimit(),
                Optional.ofNullable(from.getEnrolledStudents()).orElse(Set.of()).size()
        );
    }
}
