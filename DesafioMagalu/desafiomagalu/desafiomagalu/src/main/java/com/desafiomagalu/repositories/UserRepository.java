package com.desafiomagalu.repositories;
import com.desafiomagalu.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findUserById(Long id);
}
