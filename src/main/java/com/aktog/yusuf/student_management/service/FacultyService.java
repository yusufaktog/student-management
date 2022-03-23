package com.aktog.yusuf.student_management.service;



import com.aktog.yusuf.student_management.dto.FacultyDto;
import com.aktog.yusuf.student_management.dto.converter.FacultyDtoConverter;
import com.aktog.yusuf.student_management.dto.request.CreateFacultyRequest;
import com.aktog.yusuf.student_management.dto.request.update.UpdateFacultyRequest;
import com.aktog.yusuf.student_management.entity.Faculty;
import com.aktog.yusuf.student_management.repository.DepartmentRepository;
import com.aktog.yusuf.student_management.repository.FacultyRepository;
import com.aktog.yusuf.student_management.repository.InstructorRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;
    private final FacultyDtoConverter facultyDtoConverter;
    private final DepartmentRepository departmentRepository;
    private final InstructorRepository instructorRepository;


    public FacultyService(FacultyRepository facultyRepository,
                          FacultyDtoConverter facultyDtoConverter,
                          DepartmentRepository departmentRepository,
                          InstructorRepository instructorRepository) {
        this.facultyRepository = facultyRepository;
        this.facultyDtoConverter = facultyDtoConverter;
        this.departmentRepository = departmentRepository;
        this.instructorRepository = instructorRepository;
    }

    public FacultyDto createFaculty(CreateFacultyRequest request) {
        Faculty faculty = new Faculty(
                request.getName(),
                request.getOpeningDate()
        );
        return facultyDtoConverter.convert(facultyRepository.save(faculty));
    }

    public String deleteFaculty(Long facultyId) {
        Faculty faculty = facultyRepository.getById(facultyId);
        return String.format("Faculty id: %d, Faculty name: %s has been deleted",
                facultyId,
                faculty.getName());

    }

    public FacultyDto updateFaculty(UpdateFacultyRequest request, Long facultyId) {
        Faculty faculty = facultyRepository.getById(facultyId);
        Faculty updated = new Faculty(
                facultyId,
                request.getName(),
                faculty.getOpeningDate(),
                Optional.ofNullable(request.getDepartmentIds()).orElse(Set.of())
                        .stream()
                        .map(departmentRepository::getById)
                        .collect(Collectors.toSet()),
                Optional.ofNullable(request.getInstructorIds()).orElse(Set.of())
                        .stream()
                        .map(instructorRepository::getById)
                        .collect(Collectors.toSet())

        );
        return facultyDtoConverter.convert(facultyRepository.save(updated));
    }
    public List<Faculty> getALlFacultyList(){
        return facultyRepository.findAll();
    }

    public List<FacultyDto> getAllFacultyDtoList(){
        return facultyDtoConverter.convert(facultyRepository.findAll());
    }

    public Faculty findByFacultyId(Long facultyId){
        return facultyRepository.findById(facultyId).orElseThrow(EntityNotFoundException::new);
    }

    public FacultyDto getFacultyById(Long facultyId){
        return facultyDtoConverter.convert(facultyRepository.getById(facultyId));
    }

}