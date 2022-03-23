package com.aktog.yusuf.student_management.controller;


import com.aktog.yusuf.student_management.dto.CourseDto;
import com.aktog.yusuf.student_management.dto.request.CreateCourseRequest;
import com.aktog.yusuf.student_management.dto.request.update.UpdateCourseRequest;
import com.aktog.yusuf.student_management.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@Valid @RequestBody CreateCourseRequest request) {
        return new ResponseEntity<>(courseService.createCourse(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourseList() {
        return ResponseEntity.ok(new ArrayList<>(courseService.getAllCourseDtoList()));
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable String courseId, @Valid @RequestBody UpdateCourseRequest request) {
        return ResponseEntity.ok(courseService.updateCourse(request,courseId));
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable String courseId){
        return new ResponseEntity<>(courseService.deleteCourse(courseId),HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable String courseId){
        return  ResponseEntity.ok(courseService.getCourseById(courseId));
    }
}