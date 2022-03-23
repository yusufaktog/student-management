package com.aktog.yusuf.student_management.entity

import com.aktog.yusuf.student_management.entity.enum_types.Gender
import org.hibernate.Hibernate
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
    val name: String,
    val surname: String,
    val gender: Gender,
    val birthday: LocalDate,

    @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name = "faculty_id")
    val faculty: Faculty,

    @OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY)
    val coursesTaught: Set<Course>? = HashSet(),

    ) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Instructor

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}
