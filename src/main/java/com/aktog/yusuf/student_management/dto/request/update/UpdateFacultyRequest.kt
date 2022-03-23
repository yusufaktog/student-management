package com.aktog.yusuf.student_management.dto.request.update

data class UpdateFacultyRequest(
    val name:String,
    val departmentIds:Set<Long>? = HashSet(),
    val instructorIds:Set<String>? = HashSet()
)