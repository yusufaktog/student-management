package com.yusuf.aktog.student_management.dto.request

import com.yusuf.aktog.student_management.entity.Department
import com.yusuf.aktog.student_management.entity.EducationType
import java.time.LocalDate
import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Past
import javax.validation.constraints.PastOrPresent

data class CreateStudentRequest(

    @field:NotEmpty
    val name: String,

    @field:NotEmpty
    val surname: String,

    @field:Past
    val birthday: LocalDate,

    @field:NotEmpty
    val department: Department,

    @field:PastOrPresent
    val startYear: Int,

    val educationType: EducationType

)
