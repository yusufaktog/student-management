package com.yusuf.aktog.student_management.repository;

import com.yusuf.aktog.student_management.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor,String> {
}
