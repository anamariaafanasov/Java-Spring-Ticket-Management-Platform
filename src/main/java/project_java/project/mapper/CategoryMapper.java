package project_java.project.mapper;

import org.springframework.stereotype.Component;
import project_java.project.dto.CategoryRequest;
import project_java.project.models.Category;

@Component
public class CategoryMapper {

    public Category categoryRequestToCategory(CategoryRequest categoryRequest){
       return new Category(categoryRequest.getName());
    }
}
