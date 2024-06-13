package com.pmd.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pmd.app.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);
}
