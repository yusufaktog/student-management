package com.aktog.yusuf.student_management.controller;


import com.aktog.yusuf.student_management.dto.DepartmentDto;
import com.aktog.yusuf.student_management.dto.InstructorDto;
import com.aktog.yusuf.student_management.dto.request.CreateInstructorRequest;
import com.aktog.yusuf.student_management.dto.request.update.UpdateInstructorRequest;
import com.aktog.yusuf.student_management.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/instructor")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping
    public ResponseEntity<InstructorDto> createInstructor(@Valid @RequestBody CreateInstructorRequest request) {
        return new ResponseEntity<>(instructorService.createInstructor(request), HttpStatus.CREATED);
    }

    @PutMapping("/{facultyId}{instructorId}")
    public ResponseEntity<InstructorDto> updateInstructor(@PathVariable String instructorId,
                                                          @PathVariable Long facultyId,
                                                          @Valid @RequestBody UpdateInstructorRequest request) {
        return ResponseEntity.ok(instructorService.updateInstructor(request,instructorId,facultyId));
    }

    @DeleteMapping("/{instructorId}")
    public ResponseEntity<String> deleteInstructor(@PathVariable String instructorId){
        return new ResponseEntity<>(instructorService.deleteInstructor(instructorId),HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{instructorId}")
    public ResponseEntity<InstructorDto> getInstructorById(@PathVariable String instructorId){
        return  ResponseEntity.ok(instructorService.getInstructorById(instructorId));
    }
    @GetMapping
    public ResponseEntity<List<InstructorDto>> getAllInstructorList(){
        return  ResponseEntity.ok(instructorService.getAllInstructorDtoList());
    }
}