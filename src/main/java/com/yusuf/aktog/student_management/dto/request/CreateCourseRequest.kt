package com.yusuf.aktog.student_management.dto.request

import com.yusuf.aktog.student_management.entity.CourseDegree
import com.yusuf.aktog.student_management.entity.Instructor
import com.yusuf.aktog.student_management.entity.Language
import com.yusuf.aktog.student_management.entity.Semester
import java.time.Year

data class CreateCourseRequest @JvmOverloads constructor(

    val name:String,
    val semester: Semester,
    val courseCode:String,
    val year: Int,
    val enrollmentLimit:Int,
    val credits:Int,
    val courseDegree: CourseDegree? = CourseDegree.BACHELORS,
    val language: Language? = Language.ENGLISH,
    val instructor: Instructor

)

