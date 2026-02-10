package com.example.day3_sms.repository;
import java.util.Optional;
import com.example.day3_sms.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<UserModel, String> {
    Optional<UserModel> findByEmail(String email);
}
