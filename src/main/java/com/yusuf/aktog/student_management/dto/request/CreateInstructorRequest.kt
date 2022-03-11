package com.yusuf.aktog.student_management.dto.request

import com.yusuf.aktog.student_management.dto.CourseDto
import java.time.LocalDate

data class CreateInstructorRequest @JvmOverloads constructor(
    val name:String,
    val surname:String,
    val birthday:LocalDate,
    val lessonsTaught:Set<CourseDto>? = HashSet()
)
