package com.aktog.yusuf.student_management.controller;


import com.aktog.yusuf.student_management.dto.DepartmentDto;
import com.aktog.yusuf.student_management.dto.request.CreateDepartmentRequest;
import com.aktog.yusuf.student_management.dto.request.update.UpdateDepartmentRequest;
import com.aktog.yusuf.student_management.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@Valid @RequestBody  CreateDepartmentRequest request){
        return new ResponseEntity<>(departmentService.createDepartment(request), HttpStatus.CREATED);
    }

    @PutMapping("/{facultyId}{departmentId}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable Long departmentId,
                                                          @PathVariable Long facultyId,
                                                          @Valid @RequestBody UpdateDepartmentRequest request) {
        return ResponseEntity.ok(departmentService.updateDepartment(request,departmentId,facultyId));
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long departmentId){
        return new ResponseEntity<>(departmentService.deleteDepartment(departmentId),HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long departmentId){
        return  ResponseEntity.ok(departmentService.getDepartmentById(departmentId));
    }
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartmentList(){
        return  ResponseEntity.ok(departmentService.getAllDepartmentDtoList());
    }
}