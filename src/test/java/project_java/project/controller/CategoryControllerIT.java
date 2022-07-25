package project_java.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import project_java.project.controllers.CategoryController;
import project_java.project.dto.CategoryRequest;
import project_java.project.mapper.CategoryMapper;
import project_java.project.models.Category;
import project_java.project.services.CategoryService;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CategoryController.class)
public class CategoryControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    @MockBean
    private CategoryMapper categoryMapper;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void addNewCategory() throws Exception{
        //arrange
        CategoryRequest categoryRequest = new CategoryRequest("Music");
        Category category = new Category("Music");

        when(categoryService.addCategory(any())).thenReturn(category);
        when(categoryMapper.categoryRequestToCategory(any())).thenReturn(category);
        mockMvc.perform(
                post("/categories")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(categoryRequest))

        ).andExpect(status().isCreated())
        .andExpect(jsonPath("$.name").value(category.getName()));

    }

}
