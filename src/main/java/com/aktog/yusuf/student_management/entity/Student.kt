package com.aktog.yusuf.student_management.entity

import com.aktog.yusuf.student_management.entity.enum_types.EducationType
import com.aktog.yusuf.student_management.entity.enum_types.Gender
import org.hibernate.Hibernate
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
    val gender: Gender,
    val name: String,
    val surname: String,
    val studentNo: String,
    val birthday: LocalDate,
    val startYear:Int,
    val educationType: EducationType,

    @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name = "department_id")
    val department: Department

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Student

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}
