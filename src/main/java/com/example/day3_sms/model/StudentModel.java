package com.example.day3_sms.model;

//for getter and setter
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Data
//saare constructer khud s bn jaye
@AllArgsConstructor
@NoArgsConstructor//for student having no information
@Document(collection = "students")


public class StudentModel {
    @Id
    private String id;
    private String name;
    private int age;
    private String email;


}
