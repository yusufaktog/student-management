package com.yusuf.aktog.student_management.repository;

import com.yusuf.aktog.student_management.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}