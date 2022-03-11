package com.yusuf.aktog.student_management.dto

import java.time.LocalDate

data class StudentDto(
    val id: String,
    val studentNo: String,
    val name: String,
    val surname: String,
    val birthday: LocalDate,
    val department: DepartmentDto,
    val startDate:Int
)