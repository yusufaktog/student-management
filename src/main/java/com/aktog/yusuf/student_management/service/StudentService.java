package com.aktog.yusuf.student_management.service;

import com.aktog.yusuf.student_management.dto.StudentDto;
import com.aktog.yusuf.student_management.dto.converter.StudentDtoConverter;
import com.aktog.yusuf.student_management.dto.request.CreateStudentRequest;
import com.aktog.yusuf.student_management.dto.request.update.UpdateStudentRequest;
import com.aktog.yusuf.student_management.entity.Student;
import com.aktog.yusuf.student_management.entity.enum_types.EducationType;
import com.aktog.yusuf.student_management.exception.EnrollmentLimitException;
import com.aktog.yusuf.student_management.repository.DepartmentRepository;
import com.aktog.yusuf.student_management.repository.StudentRepository;
import com.aktog.yusuf.student_management.entity.Department;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;
    private final StudentDtoConverter converter;

    public StudentService(StudentRepository studentRepository,
                          DepartmentRepository departmentRepository,
                          StudentDtoConverter converter) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
        this.converter = converter;
    }

    @Transactional
    public StudentDto createStudent(CreateStudentRequest request) {
        Department department = departmentRepository.getById(request.getDepartmentId());

        int enrolledStudentNumber = Optional.ofNullable(department.getEnrolledStudents())
                .orElse(Set.of())
                .size();

        if (enrolledStudentNumber == department.getEnrollmentLimit())
            throw new EnrollmentLimitException(String.format("Enrollment limit of %s is over !", department.getName()));

        Student student = new Student(
                request.getGender(),
                request.getName(),
                request.getSurname(),
                generateStudentNo(request),
                request.getBirthday(),
                request.getStartYear().getValue(),
                request.getEducationType(),
                department
        );

        return converter.convert(studentRepository.save(student));
    }

    public String deleteStudent(String studentId) {
        Student student = studentRepository.getById(studentId);
        studentRepository.deleteById(studentId);
        return String.format("Student name:%s, id:%s has been deleted",
                student.getName()
                        .concat(" ")
                        .concat(student.getSurname())
                , student.getId());
    }

    public StudentDto updateStudent(UpdateStudentRequest request, String studentId) {
        Student student = studentRepository.getById(studentId);
        Department department = departmentRepository.getById(request.getDepartmentId());


        Student updated = new Student(
                studentId,
                student.getGender(),
                request.getName(),
                request.getSurname(),
                student.getStudentNo(),
                student.getBirthday(),
                student.getStartYear(),
                request.getEducationType(),
                department
        );
        return converter.convert(studentRepository.save(updated));
    }

    public List<Student> getAllStudentList() {
        return studentRepository.findAll();
    }

    public List<StudentDto> getAllStudentDtoList() {
        return converter.convert(studentRepository.findAll());
    }

    public Student findByStudentId(String studentId) {
        return studentRepository.findById(studentId).orElseThrow(EntityNotFoundException::new);
    }

    public StudentDto getStudentById(String studentId) {
        return converter.convert(studentRepository.getById(studentId));
    }

    /*
    e.g;
    1st Education,
    Computer Engineering student,
    who enrolled in 2017
    and placed 55th in alphabetical order among the students enrolled in the department
    will have an auto generated student no like '170315055' by convention.
     */
    private String generateStudentNo(CreateStudentRequest request) {
        StringBuilder studentNo = new StringBuilder();

        String startYear = String.valueOf(request.getStartYear());
        String firstPart = startYear.substring(2, 4).concat("0"); // 2017 --> 170

        studentNo.append(firstPart);

        EducationType educationType = request.getEducationType();
        String departmentCode = departmentRepository.getById(request.getDepartmentId()).getDepartmentCode();

        String secondPart = educationType == EducationType.FORMAL
                ? departmentCode
                : incrementDepartmentCode(departmentCode); // CENG formal -> 315, CENG secondary -> 316 (+1)

        studentNo.append(secondPart);

        String thirdPart = adjustEnrollmentString(
                Optional.ofNullable(departmentRepository
                                .getById(request.getDepartmentId())
                                .getEnrolledStudents())
                        .orElse(Set.of())
                        .size());

        studentNo.append(thirdPart); // Third student in alphabetical order --> 003

        return studentNo.toString();

    }

    private String incrementDepartmentCode(String departmentCode) {
        return String.valueOf(Integer.parseInt(departmentCode) + 1);
    }

    private String adjustEnrollmentString(Integer enrollment) {
        String representation = String.valueOf(enrollment);
        String adjustedEnrollment;
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