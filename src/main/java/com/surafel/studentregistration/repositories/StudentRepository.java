package com.surafel.studentregistration.repositories;

import com.surafel.studentregistration.models.Student;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
  public abstract Optional<Student> findFirstByStudentId(Long studentNumber);
  public abstract void deleteByStudentId(Long studentId);
  public abstract List<Student> findAllByFirstNameContainingOrMiddleNameContainingOrLastNameContaining(String fname, String mname, String lname, Pageable pagable);
}
