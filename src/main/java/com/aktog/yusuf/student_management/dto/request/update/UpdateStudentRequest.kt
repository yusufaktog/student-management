package com.aktog.yusuf.student_management.dto.request.update

import com.aktog.yusuf.student_management.entity.enum_types.EducationType

data class UpdateStudentRequest(
    val name:String,
    val surname:String,
    val educationType: EducationType,
    val departmentId: Long
)
