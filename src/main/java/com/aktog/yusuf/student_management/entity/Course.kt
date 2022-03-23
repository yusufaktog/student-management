package com.aktog.yusuf.student_management.entity

import com.aktog.yusuf.student_management.entity.enum_types.CourseDegree
import com.aktog.yusuf.student_management.entity.enum_types.Language
import com.aktog.yusuf.student_management.entity.enum_types.Semester
import org.hibernate.Hibernate
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
data class Course @JvmOverloads constructor(


    @Id
    @Column(name = "course_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = "",
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


    ) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Course

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}