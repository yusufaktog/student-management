package com.aktog.yusuf.student_management.dto.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class CreateDepartmentRequest(

    @field:NotEmpty(message = "Name may not be empty!")
    val name:String,

    @field:NotEmpty(message = "Department Code may not be empty!")
    val departmentCode:String,

    @field:Positive(message = "Enrollment limit must be a positive number!")
    val enrollmentLimit:Int,

    @NotNull
    val facultyId:Long

)
