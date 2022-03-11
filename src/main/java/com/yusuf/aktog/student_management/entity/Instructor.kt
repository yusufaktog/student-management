package com.yusuf.aktog.student_management.entity

import org.hibernate.annotations.GenericGenerator
import java.time.LocalDate
import javax.persistence.*

@Entity
data class Instructor @JvmOverloads constructor(
    @Id
    @Column(name = "instructor_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = "",
    val name:String,
    val surname:String,
    val birthday: LocalDate,

    @OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY)
    val lessonsTaught: Set<Course>? = HashSet(),

    )
