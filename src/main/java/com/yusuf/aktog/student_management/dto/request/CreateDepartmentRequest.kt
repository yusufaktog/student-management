package com.yusuf.aktog.student_management.dto.request

data class CreateDepartmentRequest(
    val name:String,
    val departmentCode:String,
    val enrollmentLimit:Int

)
