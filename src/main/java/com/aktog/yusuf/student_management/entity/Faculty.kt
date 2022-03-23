package com.aktog.yusuf.student_management.entity

import org.hibernate.Hibernate
import java.time.LocalDate
import javax.persistence.*

@Entity
data class Faculty @JvmOverloads constructor(
    @Id
    @Column(name = "faculty_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,
    val name: String,
    val openingDate: LocalDate,

    @OneToMany(mappedBy = "faculty", fetch = FetchType.EAGER)
    val departments:Set<Department>? = HashSet(),

    @OneToMany(mappedBy = "faculty", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val instructors: Set<Instructor>? = HashSet(),
    ) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Faculty

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}