package com.aktog.yusuf.student_management.dto

import com.aktog.yusuf.student_management.entity.enum_types.Semester

data class CourseDto (
    val id:String,
    val name:String,
    val semester: Semester,
    val year: Int,
    val instructorId:String,
    val enrollmentLimit:Int,
    val credits:Int

)