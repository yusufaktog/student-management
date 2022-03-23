package com.aktog.yusuf.student_management.dto

data class DepartmentDto(
    val id:Long,
    val name:String,
    val departmentCode:String,
    val enrollmentLimit:Int,
    val remainingEnrollmentLimit:Int
)
