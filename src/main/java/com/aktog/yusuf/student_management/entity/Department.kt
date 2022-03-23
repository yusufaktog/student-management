package com.aktog.yusuf.student_management.entity

import org.hibernate.Hibernate
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
data class Department @JvmOverloads constructor(
    @Id
    @Column(name = "department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,
    val name: String,
    val departmentCode: String,
    val enrollmentLimit: Int,

    @OneToMany(mappedBy = "department", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    val enrolledStudents: Set<Student>? = HashSet(),

    @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name = "faculty_id")
    var faculty: Faculty
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Department

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}


/*
{
    COMPUTER_ENGINEERING("315"),
    BIOENGINEERING("323"),
    INDUSTRIAL_ENGINEERING("307"),
    ELECTRICAL_AND_ELECTRONICS_ENGINEERING("310"),
    METALLURGY_AND_MATERIAL("304"),
    CIVIL_ENGINEERING("303"),
    MECHANICAL_ENGINEERING("301"),


}
*/
