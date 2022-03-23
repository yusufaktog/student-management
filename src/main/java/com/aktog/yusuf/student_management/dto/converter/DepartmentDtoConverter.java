package com.aktog.yusuf.student_management.dto.converter;

import com.aktog.yusuf.student_management.dto.DepartmentDto;
import com.aktog.yusuf.student_management.entity.Department;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DepartmentDtoConverter {

    public DepartmentDto convert(Department from) {
        return new DepartmentDto(
                Objects.requireNonNull(from.getId()),
                from.getName(),
                from.getDepartmentCode(),
                from.getEnrollmentLimit(),
                from.getEnrollmentLimit() - Optional.ofNullable(from.getEnrolledStudents())
                        .orElse(Set.of()).size()
        );
    }

    public List<DepartmentDto> convert(List<Department> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
