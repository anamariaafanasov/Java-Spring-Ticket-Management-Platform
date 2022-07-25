package project_java.project.queries;

public class CategoryQueries {
    public final static String GET_CATEGORIES_SQL = " SELECT * FROM category";
    public final static String ADD_CATEGORY = "INSERT INTO category(id,name) VALUES(null ,?)";
    public final static String DELETE_CATEGORY = "DELETE FROM category WHERE id=?";

}
