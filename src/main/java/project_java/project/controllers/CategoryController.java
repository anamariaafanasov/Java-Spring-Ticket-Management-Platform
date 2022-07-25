package project_java.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import project_java.project.dto.CategoryRequest;
import project_java.project.mapper.CategoryMapper;
import project_java.project.models.Category;
import project_java.project.services.CategoryService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@Validated
@RequestMapping("/categories")
public class CategoryController {

   private CategoryService categoryService;
   private CategoryMapper categoryMapper;

    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @PostMapping
    public ResponseEntity <?> addCategory(@Valid @RequestBody CategoryRequest categoryRequest){
         Category category = categoryMapper.categoryRequestToCategory(categoryRequest);
         Category cat = categoryService.addCategory(category);
        return ResponseEntity
                .created(URI.create("/categories/" + categoryRequest.getName())).body(cat);

    }

    @GetMapping("/get")
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @DeleteMapping("/delete")
    public List<Category> deleteCategoryById(@RequestParam int id) {
        return categoryService.deleteCategoryById(id);
    }

}
