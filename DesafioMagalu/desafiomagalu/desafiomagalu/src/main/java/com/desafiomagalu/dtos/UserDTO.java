package com.desafiomagalu.dtos;

import com.desafiomagalu.domain.user.Type;
import com.desafiomagalu.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public record UserDTO(String username, String lastname, Type type){
}
