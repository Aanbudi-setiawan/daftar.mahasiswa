package com.daftarmahasiswa.thymeleaf.service;

import com.daftarmahasiswa.thymeleaf.entity.Student;
import com.daftarmahasiswa.thymeleaf.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> showAll(){
        return studentRepository.findAll();
    }
    public void saveStudent(Student student){
        studentRepository.save(student);
    }
    public void delete(long id){
        studentRepository.deleteById(id);
    }

    public Student findId(long id){
        return studentRepository.findById(id).get();
    }

    public void deleteId(long id){
        studentRepository.deleteById(id);
    }
}
