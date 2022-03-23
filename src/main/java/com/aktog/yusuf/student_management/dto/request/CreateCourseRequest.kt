package com.aktog.yusuf.student_management.dto.request

import com.aktog.yusuf.student_management.entity.Course
import com.aktog.yusuf.student_management.entity.enum_types.CourseDegree
import com.aktog.yusuf.student_management.entity.enum_types.Language
import com.aktog.yusuf.student_management.entity.enum_types.Semester
import java.time.Year
import javax.validation.constraints.FutureOrPresent
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class CreateCourseRequest @JvmOverloads constructor(

    @field:NotEmpty(message = "Name may not be empty!")
    val name: String,

    val semester: Semester,

    @field:NotEmpty(message = "Course Code may not be empty!")
    val courseCode: String,

    @field:FutureOrPresent(message = "Course year must be a date from the present")
    val year: Year,

    @field:Positive(message = "Enrollment limit must be a positive number!")
    val enrollmentLimit: Int,

    @field:Positive(message = "Enrollment limit must be a positive number!")
    val credits: Int,

    @field:NotEmpty(message = "Invalid instructor id")
    @field:NotNull(message = "Instructor id can not be null!")
    val instructorId: String,

    val courseDegree: CourseDegree? = CourseDegree.BACHELORS,

    val language: Language? = Language.ENGLISH,

    val prerequisites: Set<Course>? = HashSet()


)

