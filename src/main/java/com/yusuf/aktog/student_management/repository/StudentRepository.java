package com.yusuf.aktog.student_management.repository;

import com.yusuf.aktog.student_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,String> {
}
