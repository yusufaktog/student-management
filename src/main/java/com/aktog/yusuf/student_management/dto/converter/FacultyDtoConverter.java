package com.aktog.yusuf.student_management.dto.converter;

import com.aktog.yusuf.student_management.dto.FacultyDto;
import com.aktog.yusuf.student_management.entity.Department;
import com.aktog.yusuf.student_management.entity.Faculty;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FacultyDtoConverter {

    public FacultyDto convert(Faculty from) {
        return new FacultyDto(
                from.getId(),
                from.getName(),
                from.getOpeningDate(),
                Optional.ofNullable(from.getDepartments())
                        .orElse(Set.of())
                        .stream()
                        .map(Department::getId)
                        .collect(Collectors.toSet())
        );
    }
    public List<FacultyDto> convert(List<Faculty> from){
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}