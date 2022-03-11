package com.yusuf.aktog.student_management.entity

import javax.persistence.*

@Entity
data class Department(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,
    val name:String,
    val departmentCode:String,
    val enrollmentLimit:Int,

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    val enrolledStudents:Set<Student>? = HashSet()


    )



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
