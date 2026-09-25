package com.restapi.expensetracker.resources;

import com.restapi.expensetracker.domain.Category;
import com.restapi.expensetracker.services.CategoryServices;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryResource {

    @Autowired
    CategoryServices categoryServices;

    @GetMapping("")
    public ResponseEntity<List<Category>> getAllCategories(HttpServletRequest request){
        int userId = (Integer) request.getAttribute("userId");
        List<Category> categories = categoryServices.fetchAllCategories(userId);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

   @GetMapping("/{categoryId}")
   public ResponseEntity<Category> getCategoryById(HttpServletRequest request,
    @PathVariable("categoryId") Integer categoryId) {
        int userId = (Integer) request.getAttribute("userId");
        Category category = categoryServices.fetchCategoryById(userId, categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
   }

    @PostMapping("")
    public ResponseEntity<Category> addCategory(HttpServletRequest request,
                                                @RequestBody Map<String, Object> categoryMap){
        int userId = (Integer) request.getAttribute("userId");
        String title = (String) categoryMap.get("title");
        String description = (String) categoryMap.get("description");
        Category category = categoryServices.addCategory(userId, title, description);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<Map<String, Boolean>> updateCategory(HttpServletRequest request,
                                                               @PathVariable("categoryId") Integer categoryId,
                                                               @RequestBody Category category){
        int userId = (Integer) request.getAttribute("userId");
        categoryServices.updateCategory(userId, categoryId, category);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
