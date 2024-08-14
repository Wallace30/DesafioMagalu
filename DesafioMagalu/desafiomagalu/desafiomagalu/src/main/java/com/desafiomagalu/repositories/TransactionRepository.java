package com.desafiomagalu.repositories;

import com.desafiomagalu.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}