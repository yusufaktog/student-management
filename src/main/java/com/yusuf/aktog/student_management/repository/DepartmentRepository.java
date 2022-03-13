package com.yusuf.aktog.student_management.repository;

import com.yusuf.aktog.student_management.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
