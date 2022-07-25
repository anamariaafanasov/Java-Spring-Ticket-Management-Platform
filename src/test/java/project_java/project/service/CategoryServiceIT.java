package project_java.project.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project_java.project.models.Category;
import project_java.project.services.CategoryService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class CategoryServiceIT {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void addCategory(){
        Category category = new Category("Opera");

        Category result = categoryService.addCategory(category);

        assertNotNull(result.getId());
        assertEquals(category.getName(), result.getName());
    }
}
