package com.aktog.yusuf.student_management.dto

import com.aktog.yusuf.student_management.entity.enum_types.EducationType
import com.aktog.yusuf.student_management.entity.enum_types.Gender
import java.time.LocalDate

data class StudentDto(
    val id: String,
    val name: String,
    val surname: String,
    val studentNo: String,
    val birthday: LocalDate,
    val department: DepartmentDto,
    val startDate:Int,
    val educationType: EducationType,
    val gender: Gender,
)