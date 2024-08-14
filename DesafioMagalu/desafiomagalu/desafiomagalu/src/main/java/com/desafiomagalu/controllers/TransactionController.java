package com.desafiomagalu.controllers;


import com.desafiomagalu.domain.transaction.Transaction;
import com.desafiomagalu.domain.user.User;
import com.desafiomagalu.dtos.TransactionDTO;
import com.desafiomagalu.exception.UserNotFoundException;
import com.desafiomagalu.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> salvarTransaction(@RequestBody TransactionDTO transaction) throws Exception {
        Transaction newtransaction = this.transactionService.salvarTransaction(transaction);
        return new ResponseEntity<>(newtransaction, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Transaction>> getAllUsers() {
        List<Transaction> transactions = this.transactionService.getAllUsers();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        try {
            transactionService.deleteTransaction(id);
            return ResponseEntity.noContent().build(); // HTTP 204 No Content
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build(); // HTTP 404 Not Found
        }
    }



}
