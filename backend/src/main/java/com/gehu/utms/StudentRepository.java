package com.gehu.utms;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByStudentId(String studentId);
    List<Student> findByBoardingStop(String boardingStop);
    boolean existsByStudentId(String studentId);
}