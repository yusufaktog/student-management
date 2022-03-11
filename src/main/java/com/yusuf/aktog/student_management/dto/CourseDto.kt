package com.yusuf.aktog.student_management.dto

import com.yusuf.aktog.student_management.entity.Semester
import java.time.Year

data class CourseDto (
    val id:Long,
    val name:String,
    val semester: Semester,
    val year: Int,
    val instructorId:String,
    val enrollmentLimit:Int,
    val credits:Int

)