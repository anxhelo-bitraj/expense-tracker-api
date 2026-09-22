package com.restapi.expensetracker.repositories;

import com.restapi.expensetracker.domain.Category;
import com.restapi.expensetracker.exception.EtBadRequestException;
import com.restapi.expensetracker.exception.EtResourceNotFoundException;

import java.util.List;

public interface CategoryRepository {

    List<Category> findAll(Integer userId) throws EtResourceNotFoundException;
    Category findById(Integer userId, Integer categoryId) throws EtResourceNotFoundException;
    Integer create(Integer userId, String title, String description) throws EtBadRequestException;
    void update(Integer categoryId, Category category) throws EtBadRequestException;
    void removeById(Integer userId, Integer categoryId);
}
