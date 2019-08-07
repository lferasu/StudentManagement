package com.surafel.studentregistration.models;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long studentId;

    @NotBlank(message = "Student number can not be empty")
    @Column(name = "student_number", nullable = false)
    String studentNumber;

    @NotBlank(message = "First name can not be empty")
    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "middle_name", nullable = true)
    String middleName;

    @NotBlank(message = "Last name can not be blank")
    @Column(name = "last_name", nullable = false)
    String lastName;

    @Digits(integer = 1, fraction = 2, message = "*Not a valid GPA ")
    @Column(name="cgpa", nullable = true)
    double cgpa;

//    @NotBlank(message = "Enrollment date can not be empty")
    @Column(name = "enrollment_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate enrollmentDate;

    @Column(name = "is_international")
    boolean isInternational;


    public Student(String firstName, String middleName, String lastName, double cgpa, LocalDate enrollmentDate, boolean isInternational) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.enrollmentDate = enrollmentDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        enrollmentDate.format(formatter);
        this.isInternational = isInternational;
    }

    public Student(String firstName, String lastName, LocalDate enrollmentDate, boolean isInternational) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.enrollmentDate = enrollmentDate;
        this.isInternational = isInternational;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        enrollmentDate.format(formatter);
    }

    public Student() {

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
//        enrollmentDate.format(formatter);
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long id)
    {
        this.studentId=id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public boolean isInternational() {
        return isInternational;
    }

    public void setInternational(boolean international) {
        isInternational = international;
    }
}
