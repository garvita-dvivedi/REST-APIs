package com.studentManagementSystem.studentSystem.repository;
import com.studentManagementSystem.studentSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// it applies the sql query automatically
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUserIdAndPassword(String userId , String password);
    boolean existsByEmail(String email);
}

