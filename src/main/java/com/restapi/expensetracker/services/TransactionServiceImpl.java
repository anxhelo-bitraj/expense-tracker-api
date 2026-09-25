package com.restapi.expensetracker.services;

import com.restapi.expensetracker.domain.Transaction;
import com.restapi.expensetracker.exception.EtBadRequestException;
import com.restapi.expensetracker.exception.EtResourceNotFoundException;
import com.restapi.expensetracker.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransactionServiceImpl implements Transactionservice{

    @Autowired
    TransactionRepository transactionRepository;
    @Override
    public List<Transaction> fetchAllTransactions(Integer userId, Integer categoryId) {
        return List.of();
    }

    @Override
    public Transaction fetchTransactionById(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException {
        return null;
    }

    @Override
    public Transaction addTransaction(Integer userId, Integer categoryId, Double amount, String note, Long transactionDate) throws EtBadRequestException {
        int transactionId = transactionRepository.create(userId,categoryId, amount, note, transactionDate);
        return transactionRepository.findById(userId, categoryId, transactionId);
    }

    @Override
    public void updateTransaction(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction) throws EtBadRequestException {

    }

    @Override
    public void removetransaction(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException {

    }
}
