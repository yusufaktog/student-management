package com.yusuf.aktog.student_management.entity

import org.hibernate.annotations.GenericGenerator
import java.time.LocalDate
import javax.persistence.*

@Entity
data class Student @JvmOverloads constructor(
    @Id
    @Column(name = "student_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = "",
    val name: String,
    val surname: String,
    val studentNo: String,
    val birthday: LocalDate,
    val startYear:Int,
    val educationType:EducationType,

    @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name = "department_id")
    val department: Department

)
