package com.aktog.yusuf.student_management.dto.request.update

import com.aktog.yusuf.student_management.entity.Course
import com.aktog.yusuf.student_management.entity.Department
import java.util.*
import kotlin.collections.HashSet

data class UpdateInstructorRequest @JvmOverloads constructor(
    val name: String,
    val surname: String,
    val departmentId: String,
    val coursesTaught: Set<Course>? = HashSet()
)
