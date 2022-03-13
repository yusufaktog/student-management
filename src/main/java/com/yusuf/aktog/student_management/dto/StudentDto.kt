package com.yusuf.aktog.student_management.dto

import com.yusuf.aktog.student_management.entity.EducationType
import com.yusuf.aktog.student_management.entity.Gender
import java.time.LocalDate

data class StudentDto(
    val id: String,
    val studentNo: String,
    val gender: Gender,
    val educationType: EducationType,
    val name: String,
    val surname: String,
    val birthday: LocalDate,
    val department: DepartmentDto,
    val startDate:Int
)