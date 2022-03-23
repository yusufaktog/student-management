package com.aktog.yusuf.student_management.dto.request

import com.aktog.yusuf.student_management.entity.Department
import com.aktog.yusuf.student_management.entity.enum_types.EducationType
import com.aktog.yusuf.student_management.entity.enum_types.Gender
import java.time.LocalDate
import java.time.Year
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Past
import javax.validation.constraints.PastOrPresent

data class CreateStudentRequest(

    @field:NotEmpty(message = "Name may not be empty!")
    val name: String,

    @field:NotEmpty(message = "Surname may not be empty!")
    val surname: String,

    @field:Past(message = "Birthday must be a date from the past")
    val birthday: LocalDate,

    @field:NotNull(message = "Department may not be null!")
    val departmentId:Long,

    @field:PastOrPresent(message = "Start year must be a date from the past or present")
    val startYear: Year,

    val educationType: EducationType,

    val gender: Gender

)
