package com.surafel.studentregistration.Services.Impl;

import com.surafel.studentregistration.repositories.StudentRepository;
import com.surafel.studentregistration.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentServiceImpl implements com.surafel.studentregistration.Services.StudentService {

    @Autowired
   StudentRepository studentRepository;

    @Override
    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Page<Student> findAllStudents(int pageno) {
       return studentRepository.findAll(PageRequest.of(pageno, 5, Sort.by("firstName")));
    }

    @Override
    public Student findByStudentId(Long studentId) {
        Student student = studentRepository.findFirstByStudentId(studentId).orElse(null);
        return student;
    }

    @Override
    public void deleteByStudentId(Long studentId) {
        studentRepository.deleteByStudentId(studentId);
    }


    @Override
    public Page<Student> findByName(String fname, String mname, String lname) {

        List<Student> students = studentRepository.findAllByFirstNameContainingOrMiddleNameContainingOrLastNameContaining(fname, mname, lname, PageRequest.of(0,5));
        return new PageImpl<Student>(students);
    }


}
