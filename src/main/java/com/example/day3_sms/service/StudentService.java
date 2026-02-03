package com.example.day3_sms.service;

import com.example.day3_sms.dto.StudentRequestDto;
import com.example.day3_sms.dto.StudentResponseDto;
import com.example.day3_sms.model.StudentModel;
import com.example.day3_sms.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    //    create
//    public StudentModel addStudent(StudentModel student){
//        return repository.save(student);
//    }

    public StudentResponseDto addStudent(StudentRequestDto dto) {
        StudentModel student = new StudentModel();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        StudentModel saved = repository.save(student);

        return new StudentResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        );
    }
    // display student
    public List<StudentModel> getStudents(){
        return repository.findAll();
    }

    // update
    public StudentModel updateStudent(String id,StudentModel student){
        StudentModel existingStudent = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Student found"));


        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setEmail(student.getEmail());

        return repository.save(existingStudent);
    }

    // delete by id
    public void deleteStudent(String id){
        StudentModel existingStudent = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Student found with id: " + id));

        repository.delete(existingStudent);
    }
}