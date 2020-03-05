package com.daftarmahasiswa.thymeleaf.repository;

import com.daftarmahasiswa.thymeleaf.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
