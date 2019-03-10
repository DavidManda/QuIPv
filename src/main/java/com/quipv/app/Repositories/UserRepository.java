package com.quipv.app.Repositories;

import com.quipv.app.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}