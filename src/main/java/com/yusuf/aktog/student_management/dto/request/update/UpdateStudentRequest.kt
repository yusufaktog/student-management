package com.yusuf.aktog.student_management.dto.request.update

import com.yusuf.aktog.student_management.entity.Department
import com.yusuf.aktog.student_management.entity.EducationType

data class UpdateStudentRequest(
    val name:String,
    val surname:String,
    val educationType: EducationType,
    val department: Department
)
