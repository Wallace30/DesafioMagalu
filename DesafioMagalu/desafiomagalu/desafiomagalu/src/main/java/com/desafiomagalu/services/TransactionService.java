package com.desafiomagalu.services;



import com.desafiomagalu.domain.transaction.Transaction;
import com.desafiomagalu.domain.user.Type;
import com.desafiomagalu.domain.user.User;
import com.desafiomagalu.dtos.TransactionDTO;
import com.desafiomagalu.exception.UserNotFoundException;
import com.desafiomagalu.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private UserService userService;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private RestTemplate restTemplate;

    public Transaction salvarTransaction(TransactionDTO transaction) throws Exception {
        User sender = this.userService.findUserById(transaction.senderId());
        User receiver = this.userService.findUserById(transaction.receiverId());
        if (sender.getType() != Type.SHOP || receiver.getType() != Type.USER) {
            throw new Exception("Tipo inválido para sender ou receiver");
        }
        Transaction newTransaction = new Transaction();
        newTransaction.setDate(transaction.date());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setMessage(transaction.message());
        newTransaction.setType(transaction.type());

        this.transactionRepository.save(newTransaction);
        this.userService.saveUser(sender);
        this.userService.saveUser(receiver);
        return newTransaction;
    }
    public List<Transaction> getAllTransacoes() {
        return this.transactionRepository.findAll();
    }
    public void deleteTransaction(Long id) {
        if(transactionRepository.findById(id).isPresent()) {
            transactionRepository.deleteById(id);
        }
        else{
            throw new UserNotFoundException("Transaction with ID " + id + " not found");
        }
    }
    public List<Transaction> getAllUsers() {
        return this.transactionRepository.findAll();
    }
}
