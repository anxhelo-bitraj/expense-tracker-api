package com.restapi.expensetracker.repositories;
import com.restapi.expensetracker.domain.User;
import com.restapi.expensetracker.exception.EtAuthException;

public interface UserRepository {

    Integer create(String firstName, String lasName, String email, String password) throws EtAuthException;

    User findByEmailAndPassword(String email, String password) throws  EtAuthException;

    Integer getCountByEmail(String email);
    User findById(Integer userId);
}
