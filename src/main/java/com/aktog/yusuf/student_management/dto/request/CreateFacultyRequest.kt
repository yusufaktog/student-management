package com.aktog.yusuf.student_management.dto.request

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDate


@JsonInclude(JsonInclude.Include.NON_NULL)
data class CreateFacultyRequest @JvmOverloads constructor(

    val name: String,
    val openingDate: LocalDate,

    val departmentIds: Set<String>? = HashSet()

)