package com.restapi.expensetracker.services;
import com.restapi.expensetracker.services.UserService;
import com.restapi.expensetracker.domain.User;
import com.restapi.expensetracker.exception.EtAuthException;

public interface UserService {
    User validateUser(String email, String password) throws EtAuthException;
    User registerUser(String firstNsme, String lastName, String email, String password) throws EtAuthException;

}
