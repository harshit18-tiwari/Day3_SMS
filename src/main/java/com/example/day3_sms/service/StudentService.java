package com.example.day3_sms.service;

import com.example.day3_sms.model.StudentModel;
import com.example.day3_sms.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
//    controller->service(buisness logic)->repository->Model
    //crud operation
    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // Create
    public StudentModel addStudent(StudentModel student) {
        //only for saving
        return repository.save(student);
    }
}
