package com.aktog.yusuf.student_management.dto.request.update

data class UpdateDepartmentRequest(
    val name:String,
    val departmentCode:String,
    val enrollmentLimit:Int,
    val facultyId:Long
)

