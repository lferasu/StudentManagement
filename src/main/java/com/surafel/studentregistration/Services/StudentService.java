package com.surafel.studentregistration.Services;

import com.surafel.studentregistration.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {

    public abstract  Student registerStudent(Student student);
    public abstract  Page<Student> findAllStudents(int pageno);
    public abstract  Student findByStudentId(Long studentId);
    public abstract  void deleteByStudentId(Long studentId);
    public abstract Page<Student> findByName(String fname, String mname, String lname);
}
