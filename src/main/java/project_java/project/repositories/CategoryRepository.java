package project_java.project.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import project_java.project.models.Category;
import project_java.project.queries.CategoryQueries;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CategoryRepository {


    private JdbcTemplate jdbcTemplate;

    public CategoryRepository(JdbcTemplate template){jdbcTemplate = template;}


    public List<Category> getCategories(){
        return jdbcTemplate.query(CategoryQueries.GET_CATEGORIES_SQL,new BeanPropertyRowMapper<>(Category.class));
    }

    public Category addCategory(Category category){

        jdbcTemplate.update(CategoryQueries.ADD_CATEGORY,category.getName());
        List <Category> query = jdbcTemplate.query(CategoryQueries.GET_CATEGORIES_SQL,new BeanPropertyRowMapper<>(Category.class));
        int last_id = query.get(query.size()-1).getId();
        category.setId(last_id);

        return category;
    }


    public List <Category> deleteCategory(int id){
        jdbcTemplate.update(CategoryQueries.DELETE_CATEGORY,id);
        return jdbcTemplate.query(CategoryQueries.GET_CATEGORIES_SQL,new BeanPropertyRowMapper<>());
    }

}
