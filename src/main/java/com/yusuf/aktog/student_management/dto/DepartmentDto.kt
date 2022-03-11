package com.yusuf.aktog.student_management.dto

data class DepartmentDto(
    val name:String,
    val departmentCode:String,
    val enrollmentLimit:Int,
    val numberOfStudents:Int
)
