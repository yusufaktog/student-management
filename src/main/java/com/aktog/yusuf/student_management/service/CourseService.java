package com.aktog.yusuf.student_management.service;

import com.aktog.yusuf.student_management.dto.CourseDto;
import com.aktog.yusuf.student_management.dto.converter.CourseDtoConverter;
import com.aktog.yusuf.student_management.dto.request.CreateCourseRequest;
import com.aktog.yusuf.student_management.dto.request.update.UpdateCourseRequest;
import com.aktog.yusuf.student_management.entity.Course;
import com.aktog.yusuf.student_management.repository.CourseRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final InstructorService instructorService;
    private final CourseDtoConverter courseDtoConverter;

    public CourseService(CourseRepository courseRepository, InstructorService instructorService, CourseDtoConverter courseDtoConverter) {
        this.courseRepository = courseRepository;
        this.instructorService = instructorService;
        this.courseDtoConverter = courseDtoConverter;
    }

    public CourseDto createCourse(CreateCourseRequest request) {
        Course course = new Course(
                request.getName(),
                request.getSemester(),
                request.getCourseCode(),
                request.getYear().getValue(),
                request.getEnrollmentLimit(),
                request.getCredits(),
                instructorService.findByInstructorId(request.getInstructorId())
        );
        return courseDtoConverter.convert(courseRepository.save(course));
    }

    public String deleteCourse(String courseId) {
        Course course = courseRepository.getById(courseId);
        courseRepository.deleteById(courseId);

        return String.format("Course name:%s, id:%s has been deleted",
                course.getName()
                        .concat(" ")
                        .concat(course.getName())
                , courseId);
    }

    public CourseDto updateCourse(UpdateCourseRequest request, String courseId){
        Course course = courseRepository.getById(courseId);

        Course updated = new Course(
                courseId,
                request.getName(),
                request.getSemester(),
                request.getCourseCode(),
                request.getYear(),
                request.getEnrollmentLimit(),
                request.getCredits(),
                instructorService.findByInstructorId(request.getInstructorId()),
                Optional.ofNullable(request.getPrerequisites()).orElse(course.getPrerequisites())

        );
        return courseDtoConverter.convert(courseRepository.save(updated));
    }
    public List<Course> getALlCourseList(){
        return courseRepository.findAll();
    }

    public List<CourseDto> getAllCourseDtoList(){
        return courseDtoConverter.convert(courseRepository.findAll());
    }

    public Course findByCourseId(String instructorId){
        return courseRepository.findById(instructorId).orElseThrow(EntityNotFoundException::new);
    }

    public CourseDto getCourseById(String courseId){
        return courseDtoConverter.convert(courseRepository.getById(courseId));
    }
}