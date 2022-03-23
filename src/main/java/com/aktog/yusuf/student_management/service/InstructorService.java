package com.aktog.yusuf.student_management.service;

import com.aktog.yusuf.student_management.dto.InstructorDto;
import com.aktog.yusuf.student_management.dto.converter.InstructorDtoConverter;
import com.aktog.yusuf.student_management.dto.request.CreateInstructorRequest;
import com.aktog.yusuf.student_management.dto.request.update.UpdateInstructorRequest;
import com.aktog.yusuf.student_management.entity.Faculty;
import com.aktog.yusuf.student_management.entity.Instructor;
import com.aktog.yusuf.student_management.repository.FacultyRepository;
import com.aktog.yusuf.student_management.repository.InstructorRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
public class InstructorService {
    private final InstructorDtoConverter instructorDtoConverter;
    private final InstructorRepository instructorRepository;
    private final FacultyRepository facultyRepository;

    public InstructorService(InstructorDtoConverter instructorDtoConverter,
                             InstructorRepository instructorRepository,
                             FacultyRepository facultyRepository) {
        this.instructorDtoConverter = instructorDtoConverter;
        this.instructorRepository = instructorRepository;
        this.facultyRepository = facultyRepository;
    }

    public InstructorDto createInstructor(CreateInstructorRequest request) {
        Faculty faculty = facultyRepository.getById(request.getDepartmentId());
        Instructor instructor = new Instructor(
                request.getName(),
                request.getSurname(),
                request.getGender(),
                request.getBirthday(),
                faculty
        );
        return instructorDtoConverter.convert(instructorRepository.save(instructor));
    }

    public String deleteInstructor(String instructorId) {
        Instructor instructor = instructorRepository.getById(instructorId);
        instructorRepository.deleteById(instructorId);

        return String.format("Instructor name:%s, id:%s has been deleted",
                instructor.getName()
                        .concat(" ")
                        .concat(instructor.getSurname())
                , instructor.getId());
    }

    public InstructorDto updateInstructor(UpdateInstructorRequest request, String instructorId, Long facultyId) {
        Instructor instructor = instructorRepository.getById(instructorId);
        Faculty faculty = facultyRepository.getById(facultyId);

        Instructor updated = new Instructor(
                instructorId,
                request.getName(),
                request.getSurname(),
                instructor.getGender(),
                instructor.getBirthday(),
                faculty,
                Optional.ofNullable(request.getCoursesTaught())
                        .orElse(Set.of())
                        .size() == 0 ? instructor.getCoursesTaught() : request.getCoursesTaught()
        );
        return instructorDtoConverter.convert(instructorRepository.save(updated));

    }

    public List<Instructor> getALlInstructorList() {
        return instructorRepository.findAll();
    }

    public List<InstructorDto> getAllInstructorDtoList() {
        return instructorDtoConverter.convert(instructorRepository.findAll());
    }

    public Instructor findByInstructorId(String instructorId) {
        return instructorRepository.findById(instructorId).orElseThrow(EntityNotFoundException::new);
    }

    public InstructorDto getInstructorById(String instructorId) {
        return instructorDtoConverter.convert(instructorRepository.getById(instructorId));
    }


}