package com.aktog.yusuf.student_management.dto

import java.time.LocalDate

data class FacultyDto(
    val id: Long? = 0,
    val name: String,
    val openingDate: LocalDate,
    val departmentIds:Set<Long>? = HashSet()
)
