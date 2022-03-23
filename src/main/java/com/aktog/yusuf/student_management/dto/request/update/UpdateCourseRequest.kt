package com.aktog.yusuf.student_management.dto.request.update

import com.aktog.yusuf.student_management.entity.Course
import com.aktog.yusuf.student_management.entity.enum_types.Semester

data class UpdateCourseRequest(
    val name: String,
    val semester: Semester,
    val courseCode: String,
    val year: Int,
    val enrollmentLimit: Int,
    val credits:Int,
    val instructorId:String,
    val prerequisites: Set<Course>? = HashSet(),

    )
