package com.restapi.expensetracker.services;

import com.restapi.expensetracker.domain.Category;
import com.restapi.expensetracker.exception.EtBadRequestException;
import com.restapi.expensetracker.exception.EtResourceNotFoundException;

import java.util.List;

public interface CategoryServices {
    List<Category> fetchAllCategories(Integer userId);

    Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException;

    Category addCategory(Integer userId, String title, String description) throws EtBadRequestException;

    void updateCategory(Integer userId, Integer categoryId, Category category) throws EtBadRequestException;

    void removeCategoryWithAllTransactions(Integer userId, Integer categoryId) throws EtResourceNotFoundException;
}
