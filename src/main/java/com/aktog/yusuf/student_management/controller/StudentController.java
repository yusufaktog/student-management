package com.aktog.yusuf.student_management.controller;


import com.aktog.yusuf.student_management.dto.StudentDto;
import com.aktog.yusuf.student_management.dto.request.CreateStudentRequest;
import com.aktog.yusuf.student_management.dto.request.update.UpdateStudentRequest;
import com.aktog.yusuf.student_management.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@Valid @RequestBody CreateStudentRequest request){
        return new ResponseEntity<>(studentService.createStudent(request), HttpStatus.CREATED);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable String studentId, @Valid @RequestBody UpdateStudentRequest request) {
        return ResponseEntity.ok(studentService.updateStudent(request,studentId));
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable String studentId){
        return new ResponseEntity<>(studentService.deleteStudent(studentId),HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable String studentId){
        return  ResponseEntity.ok(studentService.getStudentById(studentId));
    }
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudentList(){
        return  ResponseEntity.ok(studentService.getAllStudentDtoList());
    }
}