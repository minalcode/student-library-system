
package com.example.student_library_system.controller;

import com.example.student_library_system.model.Transaction;
import com.example.student_library_system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction/apis")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/save")
    public String saveTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

    @GetMapping("/findById/{id}")
    public Transaction findTransactionById(@PathVariable int id) {
        return transactionService.getTransactionById(id);
    }

    @GetMapping("/findAll")
    public List<Transaction> findAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PutMapping("/update/{id}")
    public String updateTransaction(
            @PathVariable int id,
            @RequestBody Transaction transaction) {
        return transactionService.updateTransaction(id, transaction);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTransactionById(@PathVariable int id) {
        return transactionService.deleteTransactionById(id);
    }
}
