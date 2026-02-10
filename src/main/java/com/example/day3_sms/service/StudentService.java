package com.example.day3_sms.service;

import com.example.day3_sms.dto.StudentRequestDto;
import com.example.day3_sms.dto.StudentResponseDto;
import com.example.day3_sms.exception.StudentNotFoundException;
import com.example.day3_sms.model.StudentModel;
import com.example.day3_sms.repository.StudentRepository;
import org.springframework.stereotype.Service;


import com.example.day3_sms.dto.StudentPatchDto;

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


    public StudentResponseDto addStudent(StudentRequestDto dto){
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
//    public List<StudentModel> getStudents(){
//        return repository.findAll();
//    }

    public List<StudentResponseDto> getStudents() {
        return repository.findAll()
                .stream()
                .map(s -> new StudentResponseDto(
                        s.getId(),
                        s.getName(),
                        s.getAge(),
                        s.getEmail()
                )).toList();
    }

    // update
//    public StudentModel updateStudent(String id,StudentModel student){
//        StudentModel existingStudent = repository.findById(id)
//                .orElseThrow(() -> new RuntimeException("No Student found"));
//
//
//        existingStudent.setName(student.getName());
//        existingStudent.setAge(student.getAge());
//        existingStudent.setEmail(student.getEmail());
//
//        return repository.save(existingStudent);
//    }

    public StudentResponseDto updateStudent(String id, StudentRequestDto dto) {

        StudentModel existingStudent = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id)
                );

        existingStudent.setName(dto.getName());
        existingStudent.setAge(dto.getAge());
        existingStudent.setEmail(dto.getEmail());

        StudentModel updated = repository.save(existingStudent);

        return new StudentResponseDto(
                updated.getId(),
                updated.getName(),
                updated.getAge(),
                updated.getEmail()
        );
    }


    // delete by id
    public void deleteStudent(String id){
        StudentModel existingStudent = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("No Student found with id: " + id));

        repository.delete(existingStudent);
    }

    public StudentResponseDto patchStudent(String id, StudentPatchDto dto) {

        StudentModel student = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id)
                );

        if (dto.getName() != null) {
            student.setName(dto.getName());
        }

        if (dto.getAge() != null) {
            student.setAge(dto.getAge());
        }

        if (dto.getEmail() != null) {
            student.setEmail(dto.getEmail());
        }

        StudentModel updated = repository.save(student);

        return new StudentResponseDto(
                updated.getId(),
                updated.getName(),
                updated.getAge(),
                updated.getEmail()
        );
    }

}