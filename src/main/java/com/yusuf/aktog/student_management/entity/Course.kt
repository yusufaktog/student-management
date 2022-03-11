package com.yusuf.aktog.student_management.entity

import java.time.Year
import javax.persistence.*

@Entity
data class Course @JvmOverloads constructor(


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,
    val name: String,
    val semester: Semester,
    val courseCode: String,
    val year: Int,
    val enrollmentLimit: Int,
    val credits: Int,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "instructor_id")
    val instructor: Instructor,

    @ElementCollection
    val prerequisites: Set<Course>? = HashSet(),
    val courseDegree: CourseDegree? = CourseDegree.BACHELORS,
    val language: Language? = Language.ENGLISH,


    )