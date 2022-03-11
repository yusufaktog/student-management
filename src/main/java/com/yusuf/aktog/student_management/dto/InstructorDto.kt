package com.yusuf.aktog.student_management.dto

import java.time.LocalDate

data class InstructorDto @JvmOverloads constructor(
    val id:String,
    val name:String,
    val surname:String,
    val birthday:LocalDate,
    val lessonsTaught:Set<CourseDto>? = HashSet()
)
