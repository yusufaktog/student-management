package com.aktog.yusuf.student_management.repository;

import com.aktog.yusuf.student_management.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor,String> {
}
