package com.aktog.yusuf.student_management.repository;

import com.aktog.yusuf.student_management.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,String> {
}