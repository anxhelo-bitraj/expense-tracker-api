package com.restapi.expensetracker.services;

import com.restapi.expensetracker.domain.Transaction;
import com.restapi.expensetracker.exception.EtBadRequestException;
import com.restapi.expensetracker.exception.EtResourceNotFoundException;

import java.util.List;

public interface Transactionservice {

    List<Transaction> fetchAllTransactions(Integer userId, Integer categoryId);

    Transaction fetchTransactionById(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException;
    Transaction addTransaction(Integer userId, Integer categoryId, Double amount, String note, Long transactionDate) throws EtBadRequestException;
    void updateTransaction(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction) throws EtBadRequestException;
    void removetransaction(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException;

}
