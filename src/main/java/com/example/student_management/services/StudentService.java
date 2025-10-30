package com.example.student_management.services;

import com.example.student_management.entities.Student;
import java.util.Collection;
import java.util.List;

public interface StudentService {
    Student save(Student student);
    boolean delete(int id);
    List<Student> findAll();
    long countStudents();
    Collection<Object[]> findNbrStudentByYear();
}
