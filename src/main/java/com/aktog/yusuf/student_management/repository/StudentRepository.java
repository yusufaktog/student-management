package com.aktog.yusuf.student_management.repository;

import com.aktog.yusuf.student_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,String> {
}
