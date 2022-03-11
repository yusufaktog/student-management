package com.yusuf.aktog.student_management.service;

import com.yusuf.aktog.student_management.dto.StudentDto;
import com.yusuf.aktog.student_management.dto.converter.StudentDtoConverter;
import com.yusuf.aktog.student_management.dto.request.CreateStudentRequest;
import com.yusuf.aktog.student_management.entity.EducationType;
import com.yusuf.aktog.student_management.entity.Student;
import com.yusuf.aktog.student_management.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentDtoConverter converter;

    public StudentService(StudentRepository studentRepository, StudentDtoConverter converter) {
        this.studentRepository = studentRepository;
        this.converter = converter;
    }


    public StudentDto createStudent(CreateStudentRequest request) {
        Student student = new Student(

                request.getName(),
                request.getSurname(),
                generateStudentNo(request),
                request.getBirthday(),
                request.getStartYear(),
                request.getEducationType(),
                request.getDepartment()
        );
        return converter.convert(studentRepository.save(student));

    }

    public String generateStudentNo(CreateStudentRequest request) {
        StringBuilder studentNo = new StringBuilder();

        String startYear = String.valueOf(request.getStartYear());
        String firstPart = startYear.substring(2, 4).concat("0"); // 2017 --> 170

        studentNo.append(firstPart);

        EducationType educationType = request.getEducationType();
        String departmentCode = request.getDepartment().getDepartmentCode();

        String secondPart = educationType == EducationType.FORMAL
                ? departmentCode
                : incrementDepartmentCode(departmentCode);


        studentNo.append(secondPart);


        String thirdPart = adjustEnrollmentString(
                Optional.ofNullable(request
                                .getDepartment()
                                .getEnrolledStudents())
                        .orElse(Set.of())
                        .size());

        studentNo.append(thirdPart);

        return studentNo.toString();

    }

    public String incrementDepartmentCode(String departmentCode) {
        return String.valueOf(Integer.parseInt(departmentCode) + 1);
    }

    public String adjustEnrollmentString(Integer enrollment) {
        String representation = String.valueOf(enrollment);
        String adjustedEnrollment = "";
        switch (representation.length()) {
            case 0:
            default:
                adjustedEnrollment = "000";
                break;
            case 1:
                adjustedEnrollment = "00".concat(representation);
                break;
            case 2:
                adjustedEnrollment = "0".concat(representation);
                break;
        }
        return adjustedEnrollment;
    }

}