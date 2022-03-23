package com.aktog.yusuf.student_management.dto.request

import com.aktog.yusuf.student_management.dto.CourseDto
import com.aktog.yusuf.student_management.entity.Department
import com.aktog.yusuf.student_management.entity.enum_types.Gender
import java.time.LocalDate
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Past

data class CreateInstructorRequest @JvmOverloads constructor(

    @field:NotEmpty(message = "Name may not be empty!")
    val name:String,

    @field:NotEmpty(message = "Surname may not be empty!")
    val surname:String,

    val gender: Gender,

    @field:NotNull(message = "Department may not be null!")
    val departmentId:Long,

    @field:NotNull(message = "Faculty may not be null!")
    val facultyId:Long,

    @field:Past(message = "Birthday must be a date from the past")
    val birthday:LocalDate,

    val coursesTaught:Set<CourseDto>? = HashSet()
)
