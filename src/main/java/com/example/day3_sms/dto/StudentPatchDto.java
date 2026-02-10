package com.example.day3_sms.dto;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentPatchDto {

    private String name; // optional

    @Min(value = 5, message = "Age cannot be less than 5.")
    @Max(value = 90, message = "Age cannot be more than 90.")
    private Integer age; // IMPORTANT: Integer, not int

    @Email(message = "Email should be valid.")
    private String email; // optional

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}