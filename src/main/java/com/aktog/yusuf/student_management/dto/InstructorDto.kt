package com.aktog.yusuf.student_management.dto

import com.aktog.yusuf.student_management.entity.enum_types.Gender
import java.time.LocalDate

data class InstructorDto @JvmOverloads constructor(
    val id:String,
    val name:String,
    val surname:String,
    val gender: Gender,
    val faculty: FacultyDto,
    val birthday:LocalDate,
    val lessonsTaught:Set<CourseDto>? = HashSet()
)
