package project_java.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_java.project.models.Category;
import project_java.project.repositories.CategoryRepository;

import java.util.List;
@Service
public class CategoryService {


    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories(){
        return categoryRepository.getCategories();
    }

    public Category addCategory(Category category){
         return categoryRepository.addCategory(category);
    }

    public List <Category> deleteCategoryById(int id){
        return categoryRepository.deleteCategory(id);
    }
}

