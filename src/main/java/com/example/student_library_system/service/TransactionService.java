package com.example.student_library_system.service;

import com.example.student_library_system.model.Transaction;
import com.example.student_library_system.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    // Save Transaction
    public String saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
        return "Transaction saved successfully";
    }

    // Find Transaction By Id
    public Transaction getTransactionById(int id) {
        Optional<Transaction> transactionOptional =
                transactionRepository.findById(id);

        if (transactionOptional.isPresent()) {
            return transactionOptional.get();
        } else {
            throw new RuntimeException(
                    "Transaction not found with id : " + id);
        }
    }

    // Find All Transactions
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactionList =
                transactionRepository.findAll();

        return transactionList;
    }

    // Update Transaction
    public String updateTransaction(int id, Transaction newTransaction) {
        Transaction existingTransaction = getTransactionById(id);

        existingTransaction.setDueDate(newTransaction.getDueDate());
        existingTransaction.setTransactionType(newTransaction.getTransactionType());

        transactionRepository.save(existingTransaction);

        return "Transaction updated successfully";
    }

    // Delete Transaction
    public String deleteTransactionById(int id) {
        Transaction transaction = getTransactionById(id);

        transactionRepository.delete(transaction);

        return "Transaction with id " + id
                + " is deleted successfully!";
    }
}