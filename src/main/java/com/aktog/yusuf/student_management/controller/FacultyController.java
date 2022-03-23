package com.aktog.yusuf.student_management.controller;


import com.aktog.yusuf.student_management.dto.FacultyDto;
import com.aktog.yusuf.student_management.dto.request.CreateFacultyRequest;
import com.aktog.yusuf.student_management.dto.request.update.UpdateFacultyRequest;
import com.aktog.yusuf.student_management.service.FacultyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public ResponseEntity<FacultyDto> createFaculty(@Valid @RequestBody CreateFacultyRequest request){
        return new ResponseEntity<FacultyDto>(facultyService.createFaculty(request), HttpStatus.CREATED);
    }

    @DeleteMapping("/{facultyId}")
    public ResponseEntity<String> deleteInstructorById(@PathVariable Long facultyId){
        return new ResponseEntity<String>(facultyService.deleteFaculty(facultyId),HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{facultyId}")
    public ResponseEntity<FacultyDto> getFacultyById(@PathVariable Long facultyId){
        return ResponseEntity.ok(facultyService.getFacultyById(facultyId));
    }

    @PutMapping("/{facultyId}")
    public ResponseEntity<FacultyDto> updateFaculty(@Valid @RequestBody UpdateFacultyRequest request, @PathVariable Long facultyId){
        return ResponseEntity.ok(facultyService.updateFaculty(request,facultyId));
    }

    @GetMapping
    public ResponseEntity<List<FacultyDto>> getAllFacultyList(){
        return ResponseEntity.ok(facultyService.getAllFacultyDtoList());
    }

}