package com.desafiomagalu.dtos;

import com.desafiomagalu.domain.transaction.ChannelType;
import com.desafiomagalu.domain.transaction.Transaction;
import com.desafiomagalu.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public record TransactionDTO(LocalDateTime date, Long senderId, Long receiverId, String message, ChannelType type){
}
